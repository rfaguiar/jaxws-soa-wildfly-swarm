package br.com.knight.estoque.servico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.modelo.Livro;
import br.com.knight.estoque.modelo.Usuario;
import br.com.knight.estoque.repositorio.LivroRepositoryImpl;
import br.com.knight.estoque.util.JPAHibernateTest;

/**
 * @author rogerio
 *
 */
public class LivroServiceTest extends JPAHibernateTest {

	private LivroService servico;

	@Before
	public void init(){
		servico = new LivroService(new LivroRepositoryImpl(em));
	}
	
	@Test
	public void devePesquisarTodosLivros() {
		
		List<Livro> listaLivros = servico.listarLivros();
		Livro livro = listaLivros.get(0);

		Assert.assertEquals(2, listaLivros.size());
		Assert.assertEquals("Guia do Programador", livro.getNome());
		Assert.assertEquals("Adriano Almeida", livro.getAutores().get(0).getNome());
		Assert.assertEquals("Casa do Código", livro.getEditora());
		Assert.assertEquals(2012, livro.getAnoDePublicacao(), 10);
		Assert.assertEquals("Vá do \"nunca programei\" ...", livro.getResumo());
	}
	
	@Test
	public void devePesquisarPaginadoTodosLivros() {
		
		List<Livro> listaLivros = servico.listarLivros(0, 1);
		Livro livro = listaLivros.get(0);

		Assert.assertEquals(1, listaLivros.size());
		Assert.assertEquals("Guia do Programador", livro.getNome());
		Assert.assertEquals("Adriano Almeida", livro.getAutores().get(0).getNome());
		Assert.assertEquals("Casa do Código", livro.getEditora());
		Assert.assertEquals(2012, livro.getAnoDePublicacao(), 10);
		Assert.assertEquals("Vá do \"nunca programei\" ...", livro.getResumo());
	}

	@Test
	public void deveCriarUmNovoLivro() throws UsuarioNaoAutorizadoException, SOAPException {
		em.getTransaction().begin();
		Livro livroTeste = new Livro(2012, 
					new ArrayList<Autor>(Arrays.asList(new Autor("Autor Teste", null))), 
					"Editora Teste", "Livro Teste", "");
		Usuario usuario = new Usuario("soa", "soa", "soa");
		servico.criarLivro(livroTeste, usuario);
		
		List<Livro> listaLivros = servico.listarLivros();
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
	
	@Test(expected=UsuarioNaoAutorizadoException.class)
	public void deveLancarExcecaoAoCriarUmNovoLivro() throws UsuarioNaoAutorizadoException, SOAPException {
		Livro livroTeste = new Livro(2012, 
					new ArrayList<Autor>(Arrays.asList(new Autor("Autor Teste", null))), 
					"Editora Teste", "Livro Teste", "");
		Usuario usuario = new Usuario("soa", "usuarioErrado", "senhaErrada");
		servico.criarLivro(livroTeste, usuario);
	}
	
	@Test(expected=SOAPFaultException.class)
	public void deveLancarExcecaoSoapAoCriarUmNovoLivro() throws UsuarioNaoAutorizadoException, SOAPException {
		Livro livroTeste = new Livro(2012, 
					new ArrayList<Autor>(Arrays.asList(new Autor("Autor Teste", null))), 
					"Editora Teste", "Livro Teste", "");
		Usuario usuario = new Usuario("faultCode", "usuarioErrado", "senhaErrada");
		servico.criarLivro(livroTeste, usuario);
	}

}
