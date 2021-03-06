package br.com.knight.estoque.repositorio;

import java.util.List;

import br.com.knight.estoque.modelo.Livro;

/**
 * @author rogerio
 *
 */
public interface LivroRepository {

	List<Livro> listarLivros();

	List<Livro> listarLivros(int numeroDaPagina, int tamanhoDaPagina);

	void criarLivro(Livro livro);

}
