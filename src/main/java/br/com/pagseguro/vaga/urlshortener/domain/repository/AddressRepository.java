package br.com.pagseguro.vaga.urlshortener.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pagseguro.vaga.urlshortener.domain.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
