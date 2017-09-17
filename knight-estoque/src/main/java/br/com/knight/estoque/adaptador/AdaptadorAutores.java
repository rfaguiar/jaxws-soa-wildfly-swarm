package br.com.knight.estoque.adaptador;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.com.knight.estoque.modelo.Autor;

public class AdaptadorAutores extends XmlAdapter<String, Autor> {

	@Override
	public Autor unmarshal(String autor) throws Exception {
		return new Autor(autor, null);
	}

	@Override
	public String marshal(Autor autor) throws Exception {
		return autor.getNome();
	}


}
