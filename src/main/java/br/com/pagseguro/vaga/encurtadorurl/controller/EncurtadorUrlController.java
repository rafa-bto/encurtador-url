package br.com.pagseguro.vaga.encurtadorurl.controller;

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

import br.com.pagseguro.vaga.encurtadorurl.DTO.EnderecoDTO;
import br.com.pagseguro.vaga.encurtadorurl.service.UrlService;

@RestController
public class EncurtadorUrlController {
	
	@Autowired
	UrlService urlService;
	
	@PostMapping(value = "/url")
	public String geraUrl(@RequestBody @Valid EnderecoDTO endereco, HttpServletRequest request){
		return request.getRequestURL() + "/" + urlService.geraUrlHash(endereco);
	}
	
	@GetMapping(value = "/url/{id}")
	public RedirectView buscaUrl(@PathVariable("id") String id) throws IOException, ResourceNotFoundException {
		String url = urlService.buscaUrl(id);
		if(url != null)
			return new RedirectView(url);
		else
			throw new ResourceNotFoundException("Página não encontrada");
	}

}
