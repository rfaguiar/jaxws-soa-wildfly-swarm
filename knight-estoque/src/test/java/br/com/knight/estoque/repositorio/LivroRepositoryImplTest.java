package br.com.knight.estoque.repositorio;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Livro;

public class LivroRepositoryImplTest {

	private LivroRepository repositorio;

	@Before
	public void init(){
	  repositorio = new LivroRepositoryImpl();
	}
	
	@Test
	public void devePesquisarTodosLivros() {
		
		List<Livro> listaLivros = repositorio.listarLivros();
		Livro livro = listaLivros.get(0);

		Assert.assertEquals(2, listaLivros.size());
		Assert.assertEquals("Guia do Programador", livro.getNome());
		Assert.assertEquals("Paulo Silveira", livro.getAutores().get(0));
		Assert.assertEquals("Casa do Código", livro.getEditora());
		Assert.assertEquals(2012, livro.getAnoDePublicacao(), 10);
		Assert.assertEquals("Vá do \"nunca programei\" ...", livro.getResumo());
	}

	@Test
	public void devePesquisarLivrosPaginado() {
		
		List<Livro> listaLivros = repositorio.listarLivros(0, 1);
		Livro livro = listaLivros.get(0);

		Assert.assertEquals(1, listaLivros.size());
		Assert.assertEquals("Guia do Programador", livro.getNome());
		Assert.assertEquals("Paulo Silveira", livro.getAutores().get(0));
		Assert.assertEquals("Casa do Código", livro.getEditora());
		Assert.assertEquals(2012, livro.getAnoDePublicacao(), 10);
		Assert.assertEquals("Vá do \"nunca programei\" ...", livro.getResumo());
	}
}
