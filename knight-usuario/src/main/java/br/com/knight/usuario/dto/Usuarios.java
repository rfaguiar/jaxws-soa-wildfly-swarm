package br.com.knight.usuario.dto;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.knight.usuario.modelo.Usuario;

/**
 * @author rogerio
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios {
	
	@XmlElement(name="usuario")
	private Collection<Usuario> usuarios;

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Usuarios [usuarios=" + usuarios + "]";
	}
	

}
