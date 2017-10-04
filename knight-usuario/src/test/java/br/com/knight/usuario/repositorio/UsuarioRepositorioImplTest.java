package br.com.knight.usuario.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.knight.usuario.modelo.Usuario;
import br.com.knight.usuario.util.JPAHibernateTest;

public class UsuarioRepositorioImplTest extends JPAHibernateTest {

	private UsuarioRepository repositorio;
	
	@Before
	public void init() {
		repositorio = new UsuarioRepositoryImpl(em);
	}

	@Test
	public void devePesquisarTodosUsuarios() throws Exception {		
		List<Usuario> usuarios = repositorio.todos();
		assertNotNull(usuarios);
		Usuario usuario = usuarios.get(0);
		assertEquals(1, usuario.getId(), 50);
		assertEquals("Alexandre", usuario.getNome());
		assertEquals("admin", usuario.getLogin());
		assertEquals("admin", usuario.getSenha());
	}
	
	@Test
	public void devePesquisarUsuarioPorId() throws Exception {
		Usuario usuario = repositorio.buscar(new Long(1));
		assertEquals(1, usuario.getId(), 50);
		assertEquals("Alexandre", usuario.getNome());
		assertEquals("admin", usuario.getLogin());
		assertEquals("admin", usuario.getSenha());
	}

	@Test
	public void deveInserirUmNovoUsuario() throws Exception {	
		em.getTransaction().begin();
		Usuario usuarioNovo = new Usuario("Teste", "teste", "teste");
		Usuario usuarioSalvo = repositorio.salvar(usuarioNovo);
		assertEquals(3, usuarioSalvo.getId(), 50);
		assertEquals(usuarioNovo.getNome(), usuarioSalvo.getNome());
		assertEquals(usuarioNovo.getLogin(), usuarioSalvo.getLogin());
		assertEquals(usuarioNovo.getSenha(), usuarioSalvo.getSenha());
		em.getTransaction().commit();
	}
}
