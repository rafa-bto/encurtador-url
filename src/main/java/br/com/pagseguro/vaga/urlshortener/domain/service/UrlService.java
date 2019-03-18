package br.com.pagseguro.vaga.urlshortener.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pagseguro.vaga.urlshortener.controller.DTO.AddressDto;
import br.com.pagseguro.vaga.urlshortener.domain.Address;
import br.com.pagseguro.vaga.urlshortener.domain.repository.AddressRepository;

@Service
public class UrlService {
	
	@Autowired
	AddressRepository addressRepository;

	public String saveAddress(AddressDto address) {
		return addressRepository.save(new Address(address.getUrl())).getId();		
	}

	public String getUrl(String id) {
		Optional<Address> address = addressRepository.findById(id);
		return address.isPresent() ? address.get().getUrl() : null;
	}

}
