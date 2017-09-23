package br.com.knight.estoque.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.repositorio.AutoresRepositoryImpl;
import br.com.knight.estoque.util.JPAHibernateTest;

/**
 * @author rogerio
 *
 */
public class AutoresServiceTest extends JPAHibernateTest {

	private AutoresService service;
	
	@Before
	public void init() {
		service = new AutoresService(new AutoresRepositoryImpl(em));
	}

	@Test
	public void test() {
		List<Autor> autores = service.listarAutores();		
		Autor autor = autores.get(0);		
		assertEquals(3, autores.size());		
		assertEquals("Adriano Almeida", autor.getNome());
	}

}
