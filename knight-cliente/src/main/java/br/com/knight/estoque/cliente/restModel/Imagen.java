package br.com.knight.estoque.cliente.restModel;

import java.io.Serializable;
import java.util.Arrays;

public class Imagen extends EntidadeModelo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private byte[] dados;

	private String tipo;
	private String descricao;
	
	public Imagen() {}
	
	public Imagen(byte[] dados, String descricao, String tipo) {
		this.dados = dados;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getDados() {
		return dados;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Imagen other = (Imagen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Imagen [id=" + id + ", dados=" + Arrays.toString(dados) + ", tipo=" + tipo + ", descricao=" + descricao
				+ "]";
	}	
	
}
