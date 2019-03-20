package br.com.pagseguro.vaga.urlshortener.domain;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence_keeper")
public class SequenceKeeper {

	String collectionName;
	
	BigInteger sequence;

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public BigInteger getSequence() {
		return sequence;
	}

	public void setSequence(BigInteger sequence) {
		this.sequence = sequence;
	}
	
	
}
