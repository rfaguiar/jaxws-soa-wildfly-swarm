package br.com.knight.usuario.servico;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.knight.usuario.modelo.Usuario;

@Path("/usuarios")
@Produces({MediaType.APPLICATION_XML/*, MediaType.APPLICATION_JSON*/})
@Consumes({MediaType.APPLICATION_XML/*, MediaType.APPLICATION_JSON*/})
public interface UsuariosServiceInterface {

	public static final String CAMPO_DESCRICAO_IMAGEM = "Descricao";
	public static final String PARAM_INICIO = "inicio";
	public static final String PARAM_TAMANHO_PAGINA = "tamanhoPagina";

	@GET
	public Response listarUsuarios(@HeaderParam("If-Modified-Since") Date modifiedSince,
			@QueryParam(PARAM_INICIO) @DefaultValue("0") Integer inicio,
			@QueryParam(PARAM_TAMANHO_PAGINA) @DefaultValue("20") Integer tamanhoPagina, @Context UriInfo uriInfo);

	@GET
	@Path("/{id}")
	Response find(@PathParam("id") Long id, @HeaderParam("If-Modified-Since") Date modifiedSince);

	@POST
	Response create(@Context UriInfo uriInfo, Usuario usuario);

	@PUT
	public Response update(Usuario usuario);

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, Usuario usuario);

	@DELETE
	public Response delete(Usuario usuario);

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id);

	@GET
	@Path("/{id}/foto")
	@Produces("image/*")
	public Response recuperarImagen(@PathParam("id") Long id, @HeaderParam("If-Modified-Since") Date modifiedSince);

	@Consumes("image/*")
	@Path("/{id}")
	@PUT
	public Response adicionarImagen(@HeaderParam(CAMPO_DESCRICAO_IMAGEM) String descricao, @PathParam("id") Long id,
			@Context HttpServletRequest httpServletRequest, byte[] dadosImagen);
}
