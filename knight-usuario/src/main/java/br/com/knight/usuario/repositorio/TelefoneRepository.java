package br.com.knight.usuario.repositorio;

import java.util.List;

import br.com.knight.usuario.modelo.Telefone;

public interface TelefoneRepository {

	List<Telefone> buscarPorUsuario(Long idUsuario);

}
