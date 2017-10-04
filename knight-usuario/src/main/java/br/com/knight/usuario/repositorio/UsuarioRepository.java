package br.com.knight.usuario.repositorio;

import java.util.List;

import br.com.knight.usuario.modelo.Usuario;

public interface UsuarioRepository {

	List<Usuario> todos();

	Usuario buscar(Long id);

	Usuario salvar(Usuario usuario);

}
