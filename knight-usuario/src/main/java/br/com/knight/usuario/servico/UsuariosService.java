/**
 * 
 */
package br.com.knight.usuario.servico;

import java.net.URI;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.knight.usuario.dto.Usuarios;
import br.com.knight.usuario.modelo.Usuario;
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
	public Response listarUsuarios() {
		return Response.ok(new Usuarios(repository.todos())).build();
	}

	@Override
	public Response find(Long id, Date modifiedSince) {
		Usuario usuario = repository.buscar(id);
		if (usuario != null) {
			if(modifiedSince == null || (modifiedSince != null && usuario.getDataAtualizacao().after(modifiedSince))) {
				return Response.ok(usuario).build();
			}
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

}
