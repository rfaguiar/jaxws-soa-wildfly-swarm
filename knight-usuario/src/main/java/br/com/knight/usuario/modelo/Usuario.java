package br.com.knight.usuario.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.knight.usuario.modelo.rest.Link;
import br.com.knight.usuario.servico.RESTEntity;

/**
 * @author rogerio
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name="usuario")
public class Usuario extends EntidadeModelo implements Serializable, RESTEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String login;
	
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Telefone> telefones;
	
	@OneToOne(cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.LAZY)
	@XmlTransient
	private Imagen imagen;
	
	@XmlElement(name = "link")
	@Transient
	private Collection<Link> links;
	   
	public Usuario(){}
	
	public Usuario(String nome, String login, String senha) {
		this(null, nome, login, senha, null);
	}
	
	public Usuario(Long id, String nome, String login, String senha, Imagen imagen) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.login = senha;
		this.imagen = imagen;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}	

	public Collection<Link> getLinks() {
		return links;
	}

	public void setLinks(Collection<Link> links) {
		this.links = links;
	}
	
	@Override
	   public void adicionarLink(Link link) {
	      if (links == null) {
	         links = new ArrayList<>();
	      }
	      links.add(link);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", imagen=" + imagen
				+ ", links=" + links + "]";
	}

}
