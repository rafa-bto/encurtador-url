package br.com.pagseguro.vaga.urlshortener.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "endereco")
public class Address {
	
	@Id
	String id;	
	String url;
	Long hitCount = 0L;
	
	public Address() {}
	
	public Address(String url) {
		this.url = url;
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

	public Long getHitCount() {
		return hitCount;
	}

	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}
	
	public void incrementHit() {
		this.hitCount++;
	}
}
