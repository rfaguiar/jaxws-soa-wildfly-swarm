/**
 * 
 */
package br.com.knight.usuario.servico;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	public Response find(Long id) {
		Usuario usuario = repository.buscar(id);
		if (usuario != null) {
			return Response.ok(usuario).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

}
