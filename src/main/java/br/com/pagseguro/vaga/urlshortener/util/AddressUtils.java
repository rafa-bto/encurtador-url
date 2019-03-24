package br.com.pagseguro.vaga.urlshortener.util;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import br.com.pagseguro.vaga.urlshortener.domain.SequenceKeeper;

@Component
public class AddressUtils {
		
	@Autowired
	MongoOperations mongoOperations;
	
	public BigInteger generateSequence(String collectionName) {	
	    SequenceKeeper counter = mongoOperations.findAndModify(new Query(Criteria.where("_id").is(collectionName)),
	      new Update().inc("sequence",1), FindAndModifyOptions.options().returnNew(Boolean.TRUE).upsert(Boolean.TRUE),
	      SequenceKeeper.class);
	    
	    return !Objects.isNull(counter) ? counter.getSequence() : BigInteger.valueOf(1);
	}
	
	public String encodeHash(BigInteger addressNumber) {
		return Base64.getUrlEncoder().encodeToString(addressNumber.toByteArray());
	}
	
	public BigInteger decodeHash(String hash) {
		return new BigInteger(Base64.getUrlDecoder().decode(hash));
	}
}
