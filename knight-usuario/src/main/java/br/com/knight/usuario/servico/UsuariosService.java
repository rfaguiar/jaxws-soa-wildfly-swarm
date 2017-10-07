/**
 * 
 */
package br.com.knight.usuario.servico;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.knight.usuario.dto.Usuarios;
import br.com.knight.usuario.modelo.Imagen;
import br.com.knight.usuario.modelo.Usuario;
import br.com.knight.usuario.modelo.rest.Link;
import br.com.knight.usuario.repositorio.UsuarioRepository;

/**
 * @author rogerio
 *
 */
@Stateless
public class UsuariosService implements UsuariosServiceInterface {

	@Inject
	private UsuarioRepository repository;
	
	@Override
	public Response listarUsuarios(Date modifiedSince, Integer inicio,
			Integer tamanhoPagina, UriInfo uriInfo) {
		List<Usuario> usuarios = repository.todos(inicio, tamanhoPagina);
		boolean atualizado = false;
		if (modifiedSince != null) {
			for (Usuario usuario : usuarios) {
	            if (usuario.getDataAtualizacao().after(modifiedSince)) {
	               atualizado = true;
	               break;
	            }
			}
		} else {
			atualizado = true;
		}
		
		if(atualizado) {
			for (Usuario usuario : usuarios) {
	            Link link = criarLinkImagemUsuario(usuario);
	            usuario.adicionarLink(link);
	         }

	         return Response.ok(
	        		 new Usuarios(usuarios, criarLinksUsuarios(uriInfo,
	        		 tamanhoPagina, inicio, new Long(usuarios.size())))).build();
		} else {
	         return Response.notModified().build();
		}
	}

	@Override
	public Response find(Long id, Date modifiedSince) {
		Usuario usuario = repository.buscar(id);
		if (usuario != null) {
			if(modifiedSince == null || (modifiedSince != null && usuario.getDataAtualizacao().after(modifiedSince))) {
				return Response.ok(usuario).build();
			}
			usuario.adicionarLink(criarLinkImagemUsuario(usuario));
			return Response.notModified().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@Transactional
	public Response create(UriInfo uriInfo, Usuario usuario) {
		usuario = repository.salvar(usuario);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI location = uriBuilder.path("/{id}").build(usuario.getId());
		return Response.created(location).build();
	}
	
	@Override
	public Response update(Usuario usuario) {
		repository.salvar(usuario);
		return Response.noContent().build();
	}

	@Override
	public Response update(Long id, Usuario usuario) {
		usuario.setId(id);
		return update(usuario);
	}

	@Override
	public Response delete(Usuario usuario) {
		usuario = repository.buscar(usuario.getId());
		if (usuario == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		repository.remover(usuario);
		return Response.noContent().build();
	}

	@Override
	public Response delete(Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		return delete(usuario);
	}

	@Override
	public Response recuperarImagen(Long id, Date modifiedSince) {
		Usuario usuario = repository.buscar(id);
		if (usuario == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Imagen imagen = usuario.getImagen();
		
		if (modifiedSince != null && imagen.getDataAtualizacao().before(modifiedSince)) {
			return Response.notModified().build();
		}
		return Response
				.ok(imagen.getDados(), imagen.getTipo())
				.header("Descricao", imagen.getDescricao())
				.build();
	}

	@Override
	public Response adicionarImagen(String descricao, Long id, HttpServletRequest httpServletRequest,
			byte[] dadosImagen) {
		Usuario usuario = repository.buscar(id);
		if (usuario == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Imagen imagen = new Imagen(dadosImagen, descricao, httpServletRequest.getContentType());
		usuario.setImagen(imagen);
		repository.salvar(usuario);
		return Response.noContent().build();
	}
	
	private Link criarLinkImagemUsuario(Usuario usuario) {
	      String uri = UriBuilder.fromPath("usuarios/{id}").build(usuario.getId())
	            .toString();
	      String rel = "imagem";
	      String type = "image/*";

	      return new Link(uri, rel, type);
	}

	private Link[] criarLinksUsuarios(UriInfo uriInfo, Integer tamanhoPagina,
	         Integer inicio, Long numeroUsuarios) {
	      Collection<Link> links = new ArrayList<>();

	      double numeroUsuariosDouble = numeroUsuarios;
	      double tamanhoPaginaDouble = tamanhoPagina;

	      // Arrendondamento para cima, para fornecer o número certo de
	      // páginas
	      Long numeroPaginas = (long) Math.ceil(numeroUsuariosDouble
	            / tamanhoPaginaDouble);

	      // O resultado da divisão será um int.
	      Long paginaAtual = new Long(inicio / tamanhoPagina);

	      Link linkPrimeiraPagina = new Link(
	            UriBuilder.fromPath(uriInfo.getPath()).queryParam(PARAM_INICIO, 0)
	                  .queryParam(PARAM_TAMANHO_PAGINA, tamanhoPagina).build()
	                  .toString(), "primeiraPagina");
	      links.add(linkPrimeiraPagina);

	      if (paginaAtual > 0) {
	         if (paginaAtual <= numeroPaginas) {
	            Link linkPaginaAnterior = new Link(UriBuilder
	                  .fromPath(uriInfo.getPath())
	                  .queryParam(PARAM_INICIO, (paginaAtual - 1) * tamanhoPagina)
	                  .queryParam(PARAM_TAMANHO_PAGINA, tamanhoPagina).build()
	                  .toString(), "paginaAnterior");
	            links.add(linkPaginaAnterior);
	         } else {
	            Link linkPaginaAnterior = new Link(
	                  UriBuilder
	                        .fromPath(uriInfo.getPath())
	                        .queryParam(PARAM_INICIO,
	                              (numeroPaginas - 1) * tamanhoPagina)
	                        .queryParam(PARAM_TAMANHO_PAGINA, tamanhoPagina)
	                        .build().toString(), "paginaAnterior");
	            links.add(linkPaginaAnterior);
	         }
	      }

	      if (paginaAtual < (numeroPaginas - 1)) {
	         Link linkProximaPagina = new Link(UriBuilder
	               .fromPath(uriInfo.getPath())
	               .queryParam(PARAM_INICIO, (paginaAtual + 1) * tamanhoPagina)
	               .queryParam(PARAM_TAMANHO_PAGINA, tamanhoPagina).build()
	               .toString(), "proximaPagina");
	         links.add(linkProximaPagina);
	      }

	      Link linkUltimaPagina = new Link(
	            UriBuilder
	                  .fromPath(uriInfo.getPath())
	                  .queryParam(PARAM_INICIO, (numeroPaginas - 1) * tamanhoPagina)
	                  .queryParam(PARAM_TAMANHO_PAGINA, tamanhoPagina).build()
	                  .toString(), "ultimaPagina");
	      links.add(linkUltimaPagina);

	      return links.toArray(new Link[] {});
	}
}
