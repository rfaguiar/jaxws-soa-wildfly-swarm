package br.com.knight.estoque.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.repositorio.AutoresRepository;

/**
 * @author rogerio
 *
 */
@Stateless
@WebService(name="autores")
public class AutoresService {

	@Inject
	private AutoresRepository repository;
	
	/**
	 * Construtor Default para uso do CDI
	 */
	public AutoresService() {}
	
	
	/**
	 * Construtor usado pelo teste unitario
	 * @param repository
	 */
	public AutoresService(AutoresRepository repository) {
		this.repository = repository;		
	}
	
	public List<Autor> listarAutores() {
		return repository.listarAutores();
	}

}
