package br.com.knight.usuario.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.knight.usuario.modelo.Usuario;
import br.com.knight.usuario.modelo.rest.Link;
import br.com.knight.usuario.servico.RESTEntity;

/**
 * @author rogerio
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios implements Serializable, RESTEntity {

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
	public void adicionarLink(Link link) {
		if(links == null){
			this.links = new ArrayList<Link>();
		}
		this.links.add(link);
	}

	@Override
	public String toString() {
		return "Usuarios [usuarios=" + usuarios + ", links=" + links + "]";
	}

}
