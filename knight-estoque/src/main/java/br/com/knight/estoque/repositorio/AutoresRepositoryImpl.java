package br.com.knight.estoque.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.knight.estoque.modelo.Autor;

/**
 * 
 * @author rogerio
 *
 */
public class AutoresRepositoryImpl implements AutoresRepository {


	@Inject
	private EntityManager manager;
	
	public AutoresRepositoryImpl(){}
	
	/**
	 * Construtor usado pelo teste unitario
	 * 
	 * @param manager
	 */
	public AutoresRepositoryImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public List<Autor> listarAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

}
