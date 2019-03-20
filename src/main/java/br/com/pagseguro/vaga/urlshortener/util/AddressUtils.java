package br.com.pagseguro.vaga.urlshortener.util;

import java.math.BigInteger;
import java.util.Objects;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.pagseguro.vaga.urlshortener.domain.SequenceKeeper;

@Service
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
		return new String(Base64.encodeInteger(addressNumber));
	}
	
	public BigInteger decodeHash(String hash) {
		return new BigInteger(Base64.decodeBase64(hash));
	}
}
