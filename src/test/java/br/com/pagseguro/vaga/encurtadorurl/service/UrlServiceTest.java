package br.com.pagseguro.vaga.encurtadorurl.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.pagseguro.vaga.encurtadorurl.DTO.EnderecoDTO;
import br.com.pagseguro.vaga.encurtadorurl.model.Endereco;
import br.com.pagseguro.vaga.encurtadorurl.repository.EnderecoRepository;

public class UrlServiceTest {
	
	@InjectMocks
	UrlService urlService;
	
	@Mock
	EnderecoRepository enderecoRepository;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void geraUrlHashTest() {
		Endereco endereco = new Endereco();
		endereco.setId("123teste123");
		when(enderecoRepository.save(Mockito.any())).thenReturn(endereco);
		String ret = urlService.geraUrlHash(new EnderecoDTO("www.teste.com.br"));
		assertEquals(ret, "123teste123");
	}
	
	@Test
	public void buscaUrlTest() {
		Optional<Endereco> endereco = Optional.of(new Endereco("www.teste.com.br"));
		when(enderecoRepository.findById("123teste123")).thenReturn(endereco);
		String ret = urlService.buscaUrl("123teste123");
		assertEquals(ret, "http://www.teste.com.br");
	}

}
