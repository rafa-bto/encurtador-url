package br.com.pagseguro.vaga.urlshoterner.controller;

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

import br.com.pagseguro.vaga.urlshortener.controller.UrlShortenerController;
import br.com.pagseguro.vaga.urlshortener.controller.DTO.AddressDto;
import br.com.pagseguro.vaga.urlshortener.domain.service.UrlService;

public class UrlShortenerControllerTest {
	
	@InjectMocks
	UrlShortenerController controller;
	
	@Mock
	UrlService urlService;
	
	@Mock
	HttpServletRequest request;

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void postUrlTest() {
		AddressDto address = new AddressDto("www.teste.com.br");
		when(urlService.saveAddress(address)).thenReturn("123teste123");
		when(request.getRequestURL()).thenReturn(new StringBuffer("www.localhost.com.br"));
		
		String ret = controller.postUrl(address, request);
		
		assertEquals(ret, "www.localhost.com.br/123teste123");
	}
	
	@Test
	public void getUrlTest() {
		when(urlService.getUrl("123teste123")).thenReturn("www.teste.com.br");
		try {
			RedirectView ret = controller.getUrl("123teste123");
			assertEquals(ret.getUrl(), "www.teste.com.br");
		} catch (IOException e) {
			fail("ocorreu erro de IO");
		}		
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void buscaUrlInexistenteTest() throws ResourceNotFoundException, IOException {
		controller.getUrl("123teste123");
	}

}
