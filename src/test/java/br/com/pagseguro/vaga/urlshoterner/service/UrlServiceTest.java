package br.com.pagseguro.vaga.urlshoterner.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

public class UrlServiceTest {
	
	@InjectMocks
	UrlService urlService;
	
	@Mock
	AddressRepository addressRepository;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void saveAddressTest() {
		Address address = new Address();
		address.setId("123teste123");
		when(addressRepository.save(Mockito.any())).thenReturn(address);
		String ret = urlService.saveAddress(new AddressDto("www.teste.com.br"));
		assertEquals(ret, "123teste123");
	}
	
	@Test
	public void getUrlTest() {
		Optional<Address> address = Optional.of(new Address("www.teste.com.br"));
		when(addressRepository.findById("123teste123")).thenReturn(address);
		String ret = urlService.getUrl("123teste123");
		assertEquals(ret, "http://www.teste.com.br");
	}

}
