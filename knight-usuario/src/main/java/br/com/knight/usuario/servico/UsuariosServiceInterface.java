package br.com.knight.usuario.servico;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.knight.usuario.modelo.Usuario;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public interface UsuariosServiceInterface {

	@GET
	Response listarUsuarios();
	
	@GET
	@Path("/{id}")
	Response find(@PathParam("id") Long id, @HeaderParam("If-Modified-Since") Date modifiedSince);
	
	@POST
	Response create(@Context UriInfo uriInfo, Usuario usuario);

	@Produces("image/*")
	@Path("/{id}")
	@GET
	public Response recuperarImagen(@PathParam("id") Long id, @HeaderParam("If-Modified-Since") Date modifiedSince);
	
}
