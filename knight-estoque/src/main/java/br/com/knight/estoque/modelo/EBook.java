package br.com.knight.estoque.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EBook extends Livro {

	private static final long serialVersionUID = 1L;

	private String formato = "PDF;";
	
	public EBook(){}
	
	public EBook(Integer anoDePublicacao, List<String> autores, String editora,
			String nome, String resumo) {
		super(anoDePublicacao, autores, editora, nome, resumo);
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "EBook [formato=" + formato + ", getNome()=" + getNome() + ", getAutores()=" + getAutores()
				+ ", getEditora()=" + getEditora() + ", getAnoDePublicacao()=" + getAnoDePublicacao() + ", getResumo()="
				+ getResumo() + ", getDataDeCriacao()=" + getDataDeCriacao() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
