package br.com.pagseguro.vaga.encurtadorurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "endereco")
public class Endereco {
	
	private static final String HTTP_PROTOCOL = "http://";
	@Id
	String id;	
	String url;
	
	public Endereco() {}
	
	public Endereco(String url) {
		if(url.contains("://")) this.url = url;
		else this.url = HTTP_PROTOCOL + url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
