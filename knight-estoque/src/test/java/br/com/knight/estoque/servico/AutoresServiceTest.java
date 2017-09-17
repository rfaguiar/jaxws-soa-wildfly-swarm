package br.com.knight.estoque.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Autor;

public class AutoresServiceTest {

	private AutoresService service;
	
	@Before
	public void init() {
		service = new AutoresService();
	}

	@Test
	public void test() {

		List<Autor> autores = service.listarAutores();		
		Autor autor = autores.get(0);		
		assertEquals(3, autores.size());		
		assertEquals("Adriano Almeida", autor.getNome());
	}

}
