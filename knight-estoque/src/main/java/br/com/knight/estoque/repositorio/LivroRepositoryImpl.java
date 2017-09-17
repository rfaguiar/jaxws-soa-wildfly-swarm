package br.com.knight.estoque.repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.modelo.Livro;

public class LivroRepositoryImpl implements LivroRepository {

	private List<Livro> livros;
	
	public LivroRepositoryImpl() {
		livros = new ArrayList<Livro>();
		livros.add(new Livro(2012, new ArrayList<Autor>(Arrays.asList(new Autor("Paulo Silveira", null), new Autor("Adriano Almeida", null))), "Casa do Código", "Guia do Programador", "Vá do \"nunca programei\" ..."));
		livros.add(new Livro(2012, new ArrayList<Autor>(Arrays.asList(new Autor("Vinícius Baggio Fuentes", null))), "Casa do Código", "Ruby on Rails", "Crie rapidamente aplicações web"));
	}

	@Override
	public List<Livro> listarLivros() {	
		return livros;
	}

	@Override
	public List<Livro> listarLivros(int numeroDaPagina, int tamanhoDaPagina) {
		List<Livro> livros = listarLivros();
		
		int indiceInicial = numeroDaPagina * tamanhoDaPagina;
		int indiceFinal = indiceInicial + tamanhoDaPagina;
		
		indiceFinal = indiceFinal > livros.size() ? livros.size() : indiceFinal;
		indiceInicial = indiceInicial > indiceFinal ? indiceFinal : indiceInicial;
		
		return livros.subList(indiceInicial, indiceFinal);
	}

	@Override
	public void criarLivro(Livro livro) {
		livros.add(livro);		
	}

}
