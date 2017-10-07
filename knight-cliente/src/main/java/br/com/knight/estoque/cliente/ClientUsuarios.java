package br.com.knight.estoque.cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.knight.estoque.cliente.restModel.Usuario;

public class ClientUsuarios {
	
	public static String SERVICE_CONTEXT="http://localhost:8082";
	public static String USUARIOS_CONTEXT= SERVICE_CONTEXT + "/usuarios";

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource(USUARIOS_CONTEXT + "/1");
		ClientResponse clientResponse = webResource
                    .get(ClientResponse.class);
		Usuario usuarios = clientResponse.getEntity(Usuario.class);
		System.out.println(usuarios);
	}
}
