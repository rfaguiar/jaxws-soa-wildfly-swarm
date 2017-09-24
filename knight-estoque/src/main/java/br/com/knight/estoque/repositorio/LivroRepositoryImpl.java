package br.com.knight.estoque.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.com.knight.estoque.modelo.Livro;

/**
 * @author rogerio
 *
 */
public class LivroRepositoryImpl implements LivroRepository {
	
	@Inject
	private EntityManager manager;
	
	public LivroRepositoryImpl() {}

	public LivroRepositoryImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Livro> listarLivros() {	
//		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
		Root<Livro> livro = query.from(Livro.class);
		query.select(livro);
		return manager.createQuery(query).getResultList();		
	}

	@Override
	public List<Livro> listarLivros(int numeroDaPagina, int tamanhoDaPagina) {
		int indiceInicial = numeroDaPagina * tamanhoDaPagina;
//		return manager.createQuery("select l from Livro l", Livro.class)
//				.setFirstResult(indiceInicial)
//				.setMaxResults(tamanhoDaPagina)
//				.getResultList();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
		Root<Livro> livro = query.from(Livro.class);
		livro.fetch("autores");
		query.select(livro);
		return manager.createQuery(query)
				.setFirstResult(indiceInicial)
				.setMaxResults(tamanhoDaPagina)
				.getResultList();
	}

	@Override
	@Transactional
	public void criarLivro(Livro livro) {
		manager.persist(livro);
	}

}
