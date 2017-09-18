package br.com.knight.estoque.cliente;

import br.com.knight.estoque.servico.Autor;
import br.com.knight.estoque.servico.Autores;
import br.com.knight.estoque.servico.Autores_Service;

public class ClientAutores {

	public static void main(String[] args) {
		//Inicia a fábrica dos proxies
		Autores_Service serviceFactory = new Autores_Service();
		
		//Obtém um proxy
		Autores service = serviceFactory.getAutoresPort();
		
		//imprimie autores
		service.listarAutores().forEach(autor -> imprimir(autor));
	}

	private static void imprimir(Autor autor) {
		System.out.println("Nome: " + autor.getNome());
	}
}
