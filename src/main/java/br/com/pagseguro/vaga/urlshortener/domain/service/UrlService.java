package br.com.pagseguro.vaga.urlshortener.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pagseguro.vaga.urlshortener.controller.DTO.AddressDto;
import br.com.pagseguro.vaga.urlshortener.domain.Address;
import br.com.pagseguro.vaga.urlshortener.domain.repository.AddressRepository;
import br.com.pagseguro.vaga.urlshortener.util.AddressUtils;

@Service
public class UrlService {
	
	private static final String ADDRESS_COLLECTION_NAME = "address";

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressUtils addressUtils;

	public String saveAddress(AddressDto addressDto) {
		Address address = addressRepository.save(new Address(addressDto.getUrl(),addressUtils.generateSequence(ADDRESS_COLLECTION_NAME)));		
		return addressUtils.encodeHash(address.getAddressNumber());		
	}

	public String getUrl(String id) {
		List<Address> Addresses = addressRepository.findByAddressNumber((addressUtils.decodeHash(id)));		
		if(!Addresses.isEmpty()) {
			Address address = Addresses.get(0);
			address.incrementHit();
			return addressRepository.save(address).getUrl();
		}
		return null;
				
	}
	
	public Address getAddress(String id) {
		List<Address> Addresses = addressRepository.findByAddressNumber((addressUtils.decodeHash(id)));		
		if(!Addresses.isEmpty()) {
			Address address = Addresses.get(0);
			return address;
		}
		return null;
	}
}
