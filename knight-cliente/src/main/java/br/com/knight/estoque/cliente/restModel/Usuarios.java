package br.com.knight.estoque.cliente.restModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author rogerio
 *
 */
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="usuario")
	private Collection<Usuario> usuarios;

	private Collection<Link> links;
	
	public Usuarios() {}

	public Usuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuarios(Collection<Usuario> usuarios, Link... links) {
	      this.usuarios = usuarios;
	      this.links = new ArrayList<Link>(Arrays.asList(links));
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Link> getLinks() {
		return links;
	}

	public void setLinks(Collection<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Usuarios [usuarios=" + usuarios + ", links=" + links + "]";
	}

}
