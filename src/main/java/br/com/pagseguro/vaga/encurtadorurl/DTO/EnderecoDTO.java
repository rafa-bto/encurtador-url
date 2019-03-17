package br.com.pagseguro.vaga.encurtadorurl.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {
	
	@NotEmpty(message = "A url não pode ser vazia")
	@NotNull(message = "A url não pode ser nula")
	@URL(message = "A url tem que ser valida")
	String url;
	
	

	public EnderecoDTO(
			@NotEmpty(message = "A url não pode ser vazia") 
			@NotNull(message = "A url não pode ser nula") 
			@URL(message = "A url tem que ser valida") String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
