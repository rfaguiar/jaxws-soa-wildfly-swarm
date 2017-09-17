package br.com.knight.estoque.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.knight.estoque.modelo.Autor;

public class AutoresRepositoryImpl implements AutoresRepository {

	private List<Autor> autores;
	
	public AutoresRepositoryImpl() {
		autores = new ArrayList<Autor>();
		autores.add(new Autor("Adriano Almeida", new Date()));
		autores.add(new Autor("Paulo Silveira", new Date()));
		autores.add(new Autor("Vinicius Baggio", new Date()));
	}
	
	@Override
	public List<Autor> listarAutores() {
		return autores;
	}

}
