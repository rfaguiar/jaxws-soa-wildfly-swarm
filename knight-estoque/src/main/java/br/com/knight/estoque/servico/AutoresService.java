package br.com.knight.estoque.servico;

import java.util.List;

import javax.jws.WebService;

import br.com.knight.estoque.modelo.Autor;
import br.com.knight.estoque.repositorio.AutoresRepository;
import br.com.knight.estoque.repositorio.AutoresRepositoryImpl;

@WebService(name="autores", serviceName="autores")
public class AutoresService {

	private AutoresRepository repository;
	
	public AutoresService() {
		repository = new AutoresRepositoryImpl();
	}
	
	public List<Autor> listarAutores() {
		return repository.listarAutores();
	}

}
