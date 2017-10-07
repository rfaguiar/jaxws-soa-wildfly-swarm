package br.com.knight.usuario.servico.integracao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.knight.usuario.modelo.Usuario;
import br.com.knight.usuario.servico.UsuariosServiceInterface;

public class UsuariosServiceIT {

	public static String SERVICE_CONTEXT="http://localhost:8082";
	public static String USUARIOS_CONTEXT= SERVICE_CONTEXT + "/usuarios";
	
	
	private byte[] foto;
	
	@Before
	public void setup() throws IOException {
		BufferedImage bufferedImage = ImageIO.read(UsuariosServiceIT.class
				.getResourceAsStream("/foto.png"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);
		this.foto = baos.toByteArray();
	}
	
	@Test
	public void testReceberUsuario1() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(USUARIOS_CONTEXT + "/1");
		ClientResponse clientResponse = webResource
                    .get(ClientResponse.class);

		Assert.assertEquals(200, clientResponse.getStatus());
		Usuario usuarios = clientResponse.getEntity(Usuario.class);
		Assert.assertNotNull(usuarios);		
	}
	
	/*@Test
	public void testRecepcaoImagens() throws Exception {
		Client client = Client.create();
		WebResource webResource = client.resource(USUARIOS_CONTEXT + "/1/foto");
		ClientResponse clientResponse = webResource
                    .get(ClientResponse.class);		
		
		byte[] image = clientResponse.getEntity(byte[].class);
		int status = clientResponse.getStatus();

		Assert.assertEquals(200, status);
		Assert.assertArrayEquals(foto, image);

		String descricao = clientResponse
						.getHeaders()
						.getFirst(UsuariosServiceInterface.CAMPO_DESCRICAO_IMAGEM);

		Assert.assertEquals("Foto - 2012", descricao);		
		
	}*/
}
