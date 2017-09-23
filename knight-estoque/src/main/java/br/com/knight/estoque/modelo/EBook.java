package br.com.knight.estoque.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rogerio
 *
 */
@XmlRootElement
public class EBook extends Livro {

	private static final long serialVersionUID = 1L;

	private FormatoArquivo formato;
	
	public EBook(){
		this.setFormato(FormatoArquivo.PDF);
	}
	
	public EBook(Integer anoDePublicacao, List<Autor> autores, String editora,
			String nome, String resumo) {
		super(anoDePublicacao, autores, editora, nome, resumo);
		this.setFormato(FormatoArquivo.PDF);		
	}

	public FormatoArquivo getFormato() {
		return formato;
	}

	public void setFormato(FormatoArquivo formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "EBook [formato=" + getFormato() + ", getNome()=" + getNome() + ", getAutores()=" + getAutores()
				+ ", getEditora()=" + getEditora() + ", getAnoDePublicacao()=" + getAnoDePublicacao() + ", getResumo()="
				+ getResumo() + ", getDataDeCriacao()=" + getDataDeCriacao() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
