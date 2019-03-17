package br.com.pagseguro.vaga.encurtadorurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.pagseguro.vaga.encurtadorurl.model.Endereco;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {

}
