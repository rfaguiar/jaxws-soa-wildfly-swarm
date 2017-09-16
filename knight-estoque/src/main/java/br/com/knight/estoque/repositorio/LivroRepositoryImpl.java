package br.com.knight.estoque.repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.knight.estoque.modelo.Livro;

public class LivroRepositoryImpl implements LivroRepository {

	@Override
	public List<Livro> listarLivros() {	
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro(2012, new ArrayList<String>(Arrays.asList("Paulo Silveira", "Adriano Almeida")), "Casa do Código", "Guia do Programador", "Vá do \"nunca programei\" ..."));
		livros.add(new Livro(2012, new ArrayList<String>(Arrays.asList("Vinícius Baggio Fuentes")), "Casa do Código", "Ruby on Rails", "Crie rapidamente aplicações web"));
		return livros;
	}

}