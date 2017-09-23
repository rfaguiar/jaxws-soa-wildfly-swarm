package br.com.knight.estoque.repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.modelo.Livro;
import br.com.knight.estoque.util.JPAHibernateTest;

/**
 * @author rogerio
 *
 */
public class LivroRepositoryImplTest extends JPAHibernateTest {

	private LivroRepository repositorio;

	@Before
	public void init(){
	  repositorio = new LivroRepositoryImpl(em);
	}
	
	@Test
	public void devePesquisarTodosLivros() {
		
		List<Livro> listaLivros = repositorio.listarLivros();
		Livro livro = listaLivros.get(0);

		Assert.assertEquals(2, listaLivros.size());
		Assert.assertEquals("Guia do Programador", livro.getNome());
		Assert.assertEquals("Adriano Almeida", livro.getAutores().get(0).getNome());
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
		Assert.assertEquals("Adriano Almeida", livro.getAutores().get(0).getNome());
		Assert.assertEquals("Casa do Código", livro.getEditora());
		Assert.assertEquals(2012, livro.getAnoDePublicacao(), 10);
		Assert.assertEquals("Vá do \"nunca programei\" ...", livro.getResumo());
	}
	
	@Test
	public void deveCriarUmNovoLivro() {
		em.getTransaction().begin();
		Livro livroTeste = new Livro(2012, 
					new ArrayList<Autor>(Arrays.asList(new Autor("Autor Teste", null))), 
					"Editora Teste", "Livro Teste", "");		
		repositorio.criarLivro(livroTeste);
		
		List<Livro> listaLivros = repositorio.listarLivros();
		Livro livro = listaLivros.get(2);
		Assert.assertEquals(3, listaLivros.size());
		Assert.assertEquals(livroTeste.getNome(), livro.getNome());
		Assert.assertEquals(livroTeste.getAutores().get(0).getNome(), livro.getAutores().get(0).getNome());
		Assert.assertEquals(livroTeste.getEditora(), livro.getEditora());
		Assert.assertEquals(livroTeste.getAnoDePublicacao(), livro.getAnoDePublicacao(), 10);
		Assert.assertEquals(livroTeste.getResumo(), livro.getResumo());
		//remove ao final
		em.remove(livroTeste);
		em.getTransaction().commit();
	}
}
