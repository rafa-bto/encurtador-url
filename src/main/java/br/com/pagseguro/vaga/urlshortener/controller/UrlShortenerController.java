package br.com.pagseguro.vaga.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.pagseguro.vaga.urlshortener.controller.DTO.AddressDto;
import br.com.pagseguro.vaga.urlshortener.domain.service.UrlService;

@RestController
public class UrlShortenerController {
	
	@Autowired
	UrlService urlService;
	
	@PostMapping(value = "/url")
	public String postUrl(@RequestBody @Valid AddressDto adress, HttpServletRequest request){
		return request.getRequestURL() + "/" + urlService.saveAddress(adress);
	}
	
	@GetMapping(value = "/url/{id}")
	public RedirectView getUrl(@PathVariable("id") String id) throws IOException, ResourceNotFoundException {
		String url = urlService.getUrl(id);
		if(url != null)
			return new RedirectView(url);
		else
			throw new ResourceNotFoundException("Página não encontrada");
	}

}