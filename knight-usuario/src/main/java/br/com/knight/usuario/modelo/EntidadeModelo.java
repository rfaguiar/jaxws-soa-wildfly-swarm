package br.com.knight.usuario.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@MappedSuperclass
public abstract class EntidadeModelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atualizacao")
	private Date dataAtualizacao;

	@XmlTransient
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	@XmlTransient
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@PreUpdate
	@PrePersist
	protected void ajustarDataAtualizacao() {
		this.dataAtualizacao = new Date();
	}
}
