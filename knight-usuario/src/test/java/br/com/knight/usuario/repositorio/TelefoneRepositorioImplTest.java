package br.com.knight.usuario.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.knight.usuario.modelo.Telefone;
import br.com.knight.usuario.util.JPAHibernateTest;

public class TelefoneRepositorioImplTest extends JPAHibernateTest {

	private TelefoneRepository repositorio;
	
	@Before
	public void init() {
		repositorio = new TelefoneRepositoryImpl(em);
	}

	@Test
	public void devePesquisarTodosTelefonesDoUsuarioAdmin() throws Exception {
		Long idUsuarioAdmin = 2l;
		
		List<Telefone> listaTelefone = repositorio.buscarPorUsuario(idUsuarioAdmin);
		assertNotNull(listaTelefone);
		assertEquals(2, listaTelefone.size());
		assertEquals(new Long(1), listaTelefone.get(0).getId());
		assertEquals(new Long(2), listaTelefone.get(1).getId());
	}
	

}
