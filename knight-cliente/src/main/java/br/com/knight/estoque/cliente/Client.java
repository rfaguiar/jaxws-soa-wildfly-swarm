package br.com.knight.estoque.cliente;

import br.com.knight.estoque.servico.ListagemLivro;
import br.com.knight.estoque.servico.ListagemLivroService;
import br.com.knight.estoque.servico.Livro;

public class Client {

	public static void main(String[] args) {
		//Inicia a fábrica dos proxies
		ListagemLivroService listagemLivroService = new ListagemLivroService();
		
		//Obtém um proxy
		ListagemLivro listagemLivro = listagemLivroService.getListagemLivroPort();
		
		//Executa o método remoto
		listagemLivro.listarLivros().forEach(livro -> imprimir(livro));
		
		listagemLivro.listarLivrosPaginacao(0, 1).forEach(livro -> imprimir(livro));
	}

	private static void imprimir(Livro livro) {
		System.out.println("Nome: " + livro.getNome());
	}
}
