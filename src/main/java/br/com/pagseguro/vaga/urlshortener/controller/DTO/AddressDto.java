package br.com.pagseguro.vaga.urlshortener.controller.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
	
	private static final String HTTP_PROTOCOL_DEFAULT = "http://";
	@NotEmpty(message = "A url não pode ser vazia")
	@NotNull(message = "A url não pode ser nula")
	@URL(message = "A url tem que ser valida")
	String url;

	@JsonCreator
	public AddressDto(
			@NotEmpty(message = "A url não pode ser vazia") 
			@NotNull(message = "A url não pode ser nula") 
			@URL(message = "A url tem que ser valida") String url) {
		if(url.contains("://")) this.url = url;
		else this.url = HTTP_PROTOCOL_DEFAULT + url;
	}

	public String getUrl() {
		return url;
	}
	

}
