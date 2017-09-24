/**
 * 
 */
package br.com.knight.usuario.servico;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.knight.usuario.dto.Usuarios;
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

}
