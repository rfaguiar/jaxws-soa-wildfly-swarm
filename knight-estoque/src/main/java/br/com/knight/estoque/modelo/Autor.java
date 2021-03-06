package br.com.knight.estoque.modelo;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.GetMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author rogerio
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@XmlElement(name="nome")
	private String nome;
	
	@XmlTransient
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;
		
	public Autor() {}

	public Autor(String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	@XmlElementWrapper(name="refs")
	@XmlElement(name="ref")
	@Transient
	public List<URL> getRefs() throws HttpException, IOException {

	      String autor = URLEncoder.encode(nome, "UTF-8");
	      String searchString = new StringBuilder(
	            "/ajax/services/search/web?v=1.0&q=%22").append(autor)
	            .append("%22").toString();

	      GetMethod getMethod = new GetMethod(searchString);
	      HttpState httpState = new HttpState();
	      HttpConnection httpConnection = new HttpConnection("ajax.googleapis.com",
	            80);
	      httpConnection.open();
	      getMethod.setFollowRedirects(true);
	      int result = getMethod.execute(httpState, httpConnection);
	      result = 404;

	      if (result == 200) {
	         List<URL> responseList = new ArrayList<>();
	         JSONObject jsonObject = JSONObject.fromObject(getMethod
	               .getResponseBodyAsString());
	         JSONArray results = jsonObject.getJSONObject("responseData")
	               .getJSONArray("results");
	         for (int i = 0; i < results.size(); i++) {
	            String urlCrua = results.getJSONObject(i).getString("unescapedUrl");
	            URL url = new URL(urlCrua);
	            responseList.add(url);
	         }
	         return responseList;
	      }

	      return Collections.emptyList();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

}
