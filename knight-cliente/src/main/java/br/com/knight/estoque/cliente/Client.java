package br.com.knight.estoque.cliente;

import br.com.knight.estoque.servico.CriarLivro;
import br.com.knight.estoque.servico.Livro;
import br.com.knight.estoque.servico.LivroService;
import br.com.knight.estoque.servico.LivroServiceService;
import br.com.knight.estoque.servico.SOAPException_Exception;
import br.com.knight.estoque.servico.Usuario;
import br.com.knight.estoque.servico.UsuarioNaoAutorizadoException;

public class Client {

	public static void main(String[] args) throws UsuarioNaoAutorizadoException, SOAPException_Exception {
		//Inicia a fábrica dos proxies
		LivroServiceService serviceFactory = new LivroServiceService();
		
		//Obtém um proxy
		LivroService service = serviceFactory.getLivroServicePort();
		
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
		service.criarLivro(param , usuario);
		
		//Executa o método remoto
		service.listarLivros().forEach(livro -> imprimir(livro));
		
		service.listarLivrosPaginacao(0, 1).forEach(livro -> imprimir(livro));
		
		//testa exceção da ajutenticação incorreta
		usuario.setLogin("usuarioIncorreto");
		usuario.setSenha("senhaIncorreta");
		service.criarLivro(param , usuario);
	}

	private static void imprimir(Livro livro) {
		System.out.println("Nome: " + livro.getNome());
	}
}
