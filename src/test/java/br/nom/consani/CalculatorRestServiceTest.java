package br.nom.consani;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;


public class CalculatorRestServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
        return new ResourceConfig(CalculadoraService.class);
	}

	@Test
	public void somaNumerosOkTest() {
		Double response = target("/calc/soma/20/10").request().get(Double.class);
		assertTrue(response.equals(30.0));
	}
	
	@Test
	public void subtracaoNumerosOkTest() {
		Double response = target("/calc/subtracao/20/10").request().get(Double.class);
		assertTrue(response.equals(10.0));
	}
	
	@Test
	public void multiplicacaoNumerosOkTest() {
		Double response = target("/calc/multiplicacao/20/10").request().get(Double.class);
		assertTrue(response.equals(200.0));
	}
	
	@Test
	public void divisaoNumerosOkTest() {
		Double response = target("/calc/divisao/20/10").request().get(Double.class);
		assertTrue(response.equals(2.0));
	}

	@Test
	public void divisaoDecimalPontoTest() {
		Double response = target("/calc/divisao/30.0/10.0").request().get(Double.class);
		assertTrue(response.equals(3.0));
	}
	
	@Test
	public void divisaoDecimalVirguloTest() {
		Double response = target("/calc/divisao/30,0/10,0").request().get(Double.class);
		assertTrue(response.equals(3.0));
	}
	
	@Test
	public void calculaSemParametroTest() {
		Response response = target("/calc").request().get();
		assertEquals("Informacoes sobre o serviço", 200, response.getStatus());
	}

	@Test
	public void somaNumerosInvalidosTest() {
		Response response = target("/calc/soma/arroz/feijao").request().get();
		assertEquals("Parametros invalidos", 400, response.getStatus());
	}
	
	@Test
	public void multiplicaSoPrimeiroParametroTest() {
		Response response = target("/calc/multiplicacao/10/").request().get();
		assertEquals("URL inexistente ", 404, response.getStatus());
	}

	@Test
	public void multiplicaSoSegundoParametroTest() {
		Response response = target("/calc/multiplicacao//10").request().get();
		assertEquals("URL inexistente ", 404, response.getStatus());
	}
	
	
}
