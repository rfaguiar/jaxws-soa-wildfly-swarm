package br.com.knight.estoque.servico;

import java.util.List;

import javax.jws.WebService;

import br.com.knight.estoque.modelo.Livro;
import br.com.knight.estoque.repositorio.LivroRepository;
import br.com.knight.estoque.repositorio.LivroRepositoryImpl;

@WebService
public class ListagemLivro {

	public List<Livro> listarLivros() {
		LivroRepository repository = new LivroRepositoryImpl();
		return repository.listarLivros();
	}

}
