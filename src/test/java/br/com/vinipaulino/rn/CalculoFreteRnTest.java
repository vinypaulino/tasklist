package br.com.vinipaulino.rn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.vinipaulino.modelo.Configuracao;
import br.com.vinipaulino.modelo.Frete;
import br.com.vinipaulino.modelo.FreteBuilder;
import br.com.vinipaulino.modelo.Veiculo;

public class CalculoFreteRnTest {
	
	private Configuracao config;

	@Before
	public void setUp() {
		config = new Configuracao();
		config.setValorViaPavimentada(0.54);
		config.setValorViaNaoPavimentada(0.62);
		config.setToneladaMinima(5);
		config.setTaxaCustoCarga(0.02);
	}

	@Test
	public void distanciaNaoPavimentadaZero() {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo("Caminhão caçamba");
		veiculo.setFatorValor(1.05);
		
		FreteBuilder builderFrete = new FreteBuilder();

		Frete frete = builderFrete
		.comDistanciaPavimentada(100)
		.comDistanciaNaoPavimentada(0)
		.comVeiculo(veiculo)
		.comCargaTranportada(8)
		.geraAtributosCalculo();
		
		CalculoFreteRn calculador = new CalculoFreteRn(frete, config);
		
		double freteCalculado = calculador.calculaFrete();
		double valorEsperado = 62.70;
		
		System.out.println(freteCalculado);
		
		Assert.assertEquals(valorEsperado, freteCalculado, 0.00001);
	}
	
	@Test
	public void calculaComPavimentadaZeradaECaminhaoBau() {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo("Caminhão Bau");
		veiculo.setFatorValor(1.00);
		
		FreteBuilder builderFrete = new FreteBuilder();

		Frete frete = builderFrete
		.comDistanciaPavimentada(0)
		.comDistanciaNaoPavimentada(60)
		.comVeiculo(veiculo)
		.comCargaTranportada(4)
		.geraAtributosCalculo();
		
		CalculoFreteRn calculador = new CalculoFreteRn(frete, config);
		
		double freteCalculado = calculador.calculaFrete();
		double valorEsperado = 37.20;
		
		Assert.assertEquals(valorEsperado, freteCalculado, 0.00001);
	}
	
	@Test
	public void calculaComPavimentadaENaoPavimentadaECaminhaoCacamba() {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo("Caminhão bau");
		veiculo.setFatorValor(1.00);
		
		FreteBuilder builderFrete = new FreteBuilder();

		Frete frete = builderFrete
		.comDistanciaPavimentada(80)
		.comDistanciaNaoPavimentada(20)
		.comVeiculo(veiculo)
		.comCargaTranportada(6)
		.geraAtributosCalculo();
		
		CalculoFreteRn calculador = new CalculoFreteRn(frete, config);
		
		double freteCalculado = calculador.calculaFrete();
		double valorEsperado = 57.60;
		
		Assert.assertEquals(valorEsperado, freteCalculado, 0.00001);
	}
	
}
