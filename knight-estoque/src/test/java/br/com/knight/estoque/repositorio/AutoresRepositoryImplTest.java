package br.com.knight.estoque.repositorio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.util.JPAHibernateTest;

/**
 * @author rogerio
 *
 */
public class AutoresRepositoryImplTest extends JPAHibernateTest {
	
	private AutoresRepository repository;
	
	@Before
	public void init() {
		repository = new AutoresRepositoryImpl(em);
	}

	@Test
	public void test() {
		List<Autor> autores = repository.listarAutores();	
		Autor autor = autores.get(0);		
		assertEquals(3, autores.size());		
		assertEquals("Adriano Almeida", autor.getNome());
	}

}
