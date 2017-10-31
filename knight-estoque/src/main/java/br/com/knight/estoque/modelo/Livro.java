package br.com.knight.estoque.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.knight.estoque.adaptador.AdaptadorAutores;
import br.com.knight.estoque.adaptador.AdaptadorDate;

/**
 * @author rogerio
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({EBook.class})
@Entity
@Table(name="livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@XmlElementWrapper(name="autores")
	@XmlElement(name="autor")
	@XmlJavaTypeAdapter(value = AdaptadorAutores.class)
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="livro_autor", 
		joinColumns={@JoinColumn(name="id_livro")}, 
		inverseJoinColumns={@JoinColumn(name="id_autor")})
	private List<Autor> autores;
	
	private String editora;
	
	@Column(name="ano_publicacao")
	private Integer anoDePublicacao;
	
	private String resumo;
	
	@XmlJavaTypeAdapter(value = AdaptadorDate.class)
	@Transient
	private Date dataDeCriacao;
	
	public Livro() {
		dataDeCriacao = new Date();
	}
		
	public Livro(Integer anoDePublicacao, List<Autor> autores, String editora,
			String nome, String resumo) {
		this();
		this.anoDePublicacao = anoDePublicacao;
		this.autores = autores;
		this.editora = editora;
		this.nome = nome;
		this.resumo = resumo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Integer getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(Integer anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", autores=" + autores + ", editora=" + editora
				+ ", anoDePublicacao=" + anoDePublicacao + ", resumo=" + resumo + ", dataDeCriacao=" + dataDeCriacao
				+ "]";
	}	
	
}
