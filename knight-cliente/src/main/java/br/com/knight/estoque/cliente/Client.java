package br.com.knight.estoque.cliente;

import br.com.knight.estoque.servico.CriarLivro;
import br.com.knight.estoque.servico.ListagemLivro;
import br.com.knight.estoque.servico.ListagemLivroService;
import br.com.knight.estoque.servico.Livro;
import br.com.knight.estoque.servico.Usuario;
import br.com.knight.estoque.servico.UsuarioNaoAutorizadoException;

public class Client {

	public static void main(String[] args) throws UsuarioNaoAutorizadoException {
		//Inicia a fábrica dos proxies
		ListagemLivroService listagemLivroService = new ListagemLivroService();
		
		//Obtém um proxy
		ListagemLivro listagemLivro = listagemLivroService.getListagemLivroPort();
		
		Livro novoLivro = new Livro();
		novoLivro.setNome("Livro Teste2");
		novoLivro.setEditora("Editora Teste2");
		novoLivro.setAnoDePublicacao(2010);
		novoLivro.setResumo("");
		novoLivro.setAutores(new Livro.Autores());
		Usuario usuario = new Usuario();
		usuario.setLogin("soa");
		usuario.setSenha("soa");
		//cria novo livro
		CriarLivro param = new CriarLivro();
		param.setLivro(novoLivro);
		listagemLivro.criarLivro(param , usuario);
		
		//Executa o método remoto
		listagemLivro.listarLivros().forEach(livro -> imprimir(livro));
		
		listagemLivro.listarLivrosPaginacao(0, 1).forEach(livro -> imprimir(livro));
		
		//testa exceção da ajutenticação incorreta
		usuario.setLogin("usuarioIncorreto");
		usuario.setSenha("senhaIncorreta");
		listagemLivro.criarLivro(param , usuario);
	}

	private static void imprimir(Livro livro) {
		System.out.println("Nome: " + livro.getNome());
	}
}
