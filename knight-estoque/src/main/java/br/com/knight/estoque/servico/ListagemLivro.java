package br.com.knight.estoque.servico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.knight.estoque.modelo.Livro;
import br.com.knight.estoque.modelo.Usuario;
import br.com.knight.estoque.repositorio.LivroRepository;
import br.com.knight.estoque.repositorio.LivroRepositoryImpl;

@WebService
public class ListagemLivro {
	
	private LivroRepository repository;
	
	public ListagemLivro() {
		repository = new LivroRepositoryImpl();
	}

	public List<Livro> listarLivros() {
		return repository.listarLivros();
	}

	//configuração para usar assinatura metodos java iguais(sobrecarga)
	//webservice devem obrigatoriamente diferentes
	//poderia não utilizar sobecarga para simplificar a config
	@RequestWrapper(
			className="br.com.knight.estoque.servico.jaxws.ListarLivrosPaginacao",
			localName="listarLivrosPaginacao")
	@ResponseWrapper(
			className="br.com.knight.estoque.servico.jaxws.ListarLivrosPaginacaoResponse",
			localName="listarLivrosPaginacaoResponse")
	@WebResult(name="livro")
	@WebMethod(operationName="listarLivrosPaginacao")
	public List<Livro> listarLivros(
			@WebParam(name="numeroDaPagina") int numeroDaPagina, 
			@WebParam(name="tamanhoDaPagina") int tamanhoDaPagina) {
		return repository.listarLivros(numeroDaPagina, tamanhoDaPagina);
	}

	public void criarLivro(
			@WebParam(name="livro") Livro livro, 
			@WebParam(name="usuario", header=true) Usuario usuario) 
		throws UsuarioNaoAutorizadoException {
		
		if ("soa".equals(usuario.getLogin()) 
			&& "soa".equals(usuario.getSenha())) {
			repository.criarLivro(livro);
		} else {
			throw new UsuarioNaoAutorizadoException("Não autorizado");
		}
		
	}

}
