package br.com.knight.estoque.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	@Override
	public List<Livro> listarLivros(int numeroDaPagina, int tamanhoDaPagina) {
		int indiceInicial = numeroDaPagina * tamanhoDaPagina;
		return manager.createQuery("select l from Livro l", Livro.class)
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
