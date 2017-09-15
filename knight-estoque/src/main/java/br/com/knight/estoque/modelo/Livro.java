package br.com.knight.estoque.modelo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private List<String> autores;
	private String editora;
	private Integer anoDePublicacao;
	private String resumo;
	
	public Livro() {}
		
	public Livro(Integer anoDePublicacao, List<String> autores, String editora,
			String nome, String resumo) {
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
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
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
				+ anoDePublicacao + ", resumo=" + resumo + "]";
	}
	
	
}
