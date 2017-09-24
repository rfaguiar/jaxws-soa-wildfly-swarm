package br.com.knight.estoque.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
//		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> query = builder.createQuery(Autor.class);
		Root<Autor> autor = query.from(Autor.class);
		query.select(autor);
		return manager.createQuery(query).getResultList();		
	}

}
