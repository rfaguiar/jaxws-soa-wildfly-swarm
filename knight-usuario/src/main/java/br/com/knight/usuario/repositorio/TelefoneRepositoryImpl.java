package br.com.knight.usuario.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.knight.usuario.modelo.Telefone;

public class TelefoneRepositoryImpl implements TelefoneRepository {

	@Inject
	private EntityManager manager;
	
	/**
	 * Construtor Padrão
	 */
	public TelefoneRepositoryImpl() {}

	/**
	 * Construtor para teste unitario
	 * 
	 * @param manager
	 */
	public TelefoneRepositoryImpl(EntityManager manager) {
		this.manager = manager;		
	}

	/*@Override
	public List<Telefone> buscarPorUsuario(Long idUsuario) {
		String query = "SELECT tel FROM Telefone tel where tel.usuario.id = :idusuario";
		return manager.createQuery(query, Telefone.class).setParameter("idusuario", idUsuario).getResultList();
	}*/
	
	@Override
	public List<Telefone> buscarPorUsuario(Long idUsuario) {
	    return this.manager
	        .createNamedQuery(Telefone.TELEFONE_BUSCA_POR_USUARIO, Telefone.class)
	        .setParameter("idusuario", idUsuario)
	        .getResultList();
	}

}
