package br.com.pagseguro.vaga.urlshoterner.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.pagseguro.vaga.urlshortener.controller.DTO.AddressDto;
import br.com.pagseguro.vaga.urlshortener.domain.Address;
import br.com.pagseguro.vaga.urlshortener.domain.repository.AddressRepository;
import br.com.pagseguro.vaga.urlshortener.domain.service.UrlService;
import br.com.pagseguro.vaga.urlshortener.util.AddressUtils;

public class UrlServiceTest {
	
	@InjectMocks
	UrlService urlService;
	
	@Mock
	AddressRepository addressRepository;
	
	@Mock
	AddressUtils addressUtils;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void saveAddressTest() {
		Address address = new Address();
		address.setId("1111");
		when(addressRepository.save(Mockito.any())).thenReturn(address);
		when(addressUtils.generateSequence(Mockito.any())).thenReturn(BigInteger.valueOf(1));
		when(addressUtils.encodeHash(Mockito.any())).thenReturn("123teste123");
		String ret = urlService.saveAddress(new AddressDto("www.teste.com.br"));
		assertEquals(ret, "123teste123");
	}
	
	@Test
	public void getUrlTest() {
		List<Address> address = new ArrayList<>();
		address.add(new Address("http://www.teste.com.br", BigInteger.valueOf(1)));
		when(addressRepository.findByAddressNumber(Mockito.any())).thenReturn(address);
		when(addressRepository.save(Mockito.any())).thenReturn(address.get(0));
		String ret = urlService.getUrl("123teste123");
		assertEquals(ret, "http://www.teste.com.br");
	}
	
	@Test
	public void getAddressTest() {
		List<Address> address = new ArrayList<>();
		address.add(new Address("http://www.teste.com.br", BigInteger.valueOf(1)));
		when(addressRepository.findByAddressNumber(Mockito.any())).thenReturn(address);
		assertEquals(address.get(0), urlService.getAddress("123teste123"));
	}

}
