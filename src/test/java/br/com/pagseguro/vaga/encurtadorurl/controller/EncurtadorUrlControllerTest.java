package br.com.pagseguro.vaga.encurtadorurl.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.servlet.view.RedirectView;

import br.com.pagseguro.vaga.encurtadorurl.DTO.EnderecoDTO;
import br.com.pagseguro.vaga.encurtadorurl.service.UrlService;

public class EncurtadorUrlControllerTest {
	
	@InjectMocks
	EncurtadorUrlController controller;
	
	@Mock
	UrlService urlService;
	
	@Mock
	HttpServletRequest request;

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void geraUrlTest() {
		EnderecoDTO endereco = new EnderecoDTO("www.teste.com.br");
		when(urlService.geraUrlHash(endereco)).thenReturn("123teste123");
		when(request.getRequestURL()).thenReturn(new StringBuffer("www.localhost.com.br"));
		
		String ret = controller.geraUrl(endereco, request);
		
		assertEquals(ret, "www.localhost.com.br/123teste123");
	}
	
	@Test
	public void buscaUrlTest() {
		when(urlService.buscaUrl("123teste123")).thenReturn("www.teste.com.br");
		try {
			RedirectView ret = controller.buscaUrl("123teste123");
			assertEquals(ret.getUrl(), "www.teste.com.br");
		} catch (IOException e) {
			fail("ocorreu erro de IO");
		}		
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void buscaUrlInexistenteTest() throws ResourceNotFoundException, IOException {
		controller.buscaUrl("123teste123");
	}

}
