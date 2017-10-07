package br.com.knight.estoque.cliente.restModel;

import java.io.Serializable;
import java.util.Date;

public abstract class EntidadeModelo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dataAtualizacao;

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
