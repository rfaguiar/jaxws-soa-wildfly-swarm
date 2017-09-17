package br.com.knight.estoque.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.knight.estoque.adaptador.AdaptadorAutores;
import br.com.knight.estoque.adaptador.AdaptadorDate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({EBook.class})
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	
	@XmlElementWrapper(name="autores")
	@XmlElement(name="autor")
	@XmlJavaTypeAdapter(value = AdaptadorAutores.class)
	private List<Autor> autores;
	private String editora;
	private Integer anoDePublicacao;
	private String resumo;
	
	@XmlJavaTypeAdapter(value = AdaptadorDate.class)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autores=" + autores + ", editora=" + editora + ", anoDePublicacao="
				+ anoDePublicacao + ", resumo=" + resumo + ", dataDeCriacao=" + dataDeCriacao + "]";
	}
	
}
