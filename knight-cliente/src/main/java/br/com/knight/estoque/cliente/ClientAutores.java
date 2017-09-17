package br.com.knight.estoque.cliente;

import br.com.knight.estoque.servico.Autor;
import br.com.knight.estoque.servico.AutoresService;
import br.com.knight.estoque.servico.AutoresServiceService;

public class ClientAutores {

	public static void main(String[] args) {
		//Inicia a fábrica dos proxies
		AutoresServiceService serviceFactory = new AutoresServiceService();
		
		//Obtém um proxy
		AutoresService service = serviceFactory.getAutoresServicePort();
		
		//imprimie autores
		service.listarAutores().forEach(autor -> imprimir(autor));
	}

	private static void imprimir(Autor autor) {
		System.out.println("Nome: " + autor.getNome());
	}
}
