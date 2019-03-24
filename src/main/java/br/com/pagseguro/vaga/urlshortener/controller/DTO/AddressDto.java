package br.com.pagseguro.vaga.urlshortener.controller.DTO;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
	
	private static final String HTTP_PROTOCOL_DEFAULT = "http://";
	String url;

	public AddressDto() {}
	
	@JsonCreator
	public AddressDto(String url) {
		Assert.notNull(url, "the URL cannot be null");
		Assert.isTrue(!url.isEmpty(), "the URL cannot be empty");
		Assert.isTrue(url.contains("."), "the URL must be valid");
		
		if(url.contains("://")) this.url = url;
		else this.url = HTTP_PROTOCOL_DEFAULT + url;
	}

	public String getUrl() {
		return url;
	}
	

}
