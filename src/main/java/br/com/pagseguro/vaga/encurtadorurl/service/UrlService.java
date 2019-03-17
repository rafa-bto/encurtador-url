package br.com.pagseguro.vaga.encurtadorurl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pagseguro.vaga.encurtadorurl.DTO.EnderecoDTO;
import br.com.pagseguro.vaga.encurtadorurl.model.Endereco;
import br.com.pagseguro.vaga.encurtadorurl.repository.EnderecoRepository;

@Service
public class UrlService {
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public String geraUrlHash(EnderecoDTO endereco) {
		return enderecoRepository.save(new Endereco(endereco.getUrl())).getId();		
	}

	public String buscaUrl(String id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.isPresent() ? endereco.get().getUrl() : null;
	}

}
