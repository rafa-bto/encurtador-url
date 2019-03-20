package br.com.pagseguro.vaga.urlshortener.domain.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pagseguro.vaga.urlshortener.domain.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
	
	public List<Address> findByAddressNumber(BigInteger addressNumber);
}
