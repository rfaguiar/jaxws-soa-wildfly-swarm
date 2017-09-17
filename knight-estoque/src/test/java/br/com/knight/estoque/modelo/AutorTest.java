package br.com.knight.estoque.modelo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.junit.Test;

public class AutorTest {

	@Test
	public void test() throws HttpException, IOException {
		Autor adriano = new Autor("Adriano Almeida", new Date());
		List<URL> referencias = adriano.getRefs();
		referencias.forEach(ref -> {System.out.println(ref);});
		assertTrue(referencias.isEmpty());
	}

}
