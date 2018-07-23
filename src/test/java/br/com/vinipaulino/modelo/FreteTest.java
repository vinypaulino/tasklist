package br.com.vinipaulino.modelo;

import org.junit.Test;

public class FreteTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarCalculoFreteSemDistancia() {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo("Caminhão Caçamba");
		veiculo.setFatorValor(1.05);
		FreteBuilder builderFrete = new FreteBuilder();

		builderFrete
		.comDistanciaPavimentada(0)
		.comDistanciaNaoPavimentada(0)
		.comVeiculo(veiculo)
		.comCargaTranportada(8)
		.geraAtributosCalculo();
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarCalculoSemQuantidade() {
		Veiculo veiculo = new Veiculo();
		veiculo.setFatorValor(1.00);
		veiculo.setTipoVeiculo("CaminhãoBau");

		FreteBuilder builderFrete = new FreteBuilder();

		builderFrete
		.comDistanciaPavimentada(0)
		.comDistanciaNaoPavimentada(0)
		.comVeiculo(veiculo)
		.comCargaTranportada(8)
		.geraAtributosCalculo();
	}

	@Test(expected = IllegalArgumentException.class)
	public void veiculoNaoPodeSerNull() {
		FreteBuilder builderFrete = new FreteBuilder();

		builderFrete
		.comDistanciaPavimentada(0)
		.comDistanciaNaoPavimentada(0)
		.comVeiculo(null)
		.comCargaTranportada(8)
		.geraAtributosCalculo();
	}
}
