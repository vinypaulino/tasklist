package br.com.vinipaulino.modelo;

public class FreteBuilder {
	private double distanciaPavimentada;
	private double distanciaNaoPavimentada;
	private Veiculo veiculo;
	private int cargaTransportada;

	public FreteBuilder comDistanciaPavimentada(double distanciaPavimentada) {
		this.distanciaPavimentada = distanciaPavimentada;
		return this;
	}

	public FreteBuilder comDistanciaNaoPavimentada(double distanciaNaoPavimentada) {
		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
		return this;
	}

	public FreteBuilder comVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
		return this;
	}

	public FreteBuilder comCargaTranportada(int cargaTransportada) {
		this.cargaTransportada = cargaTransportada;
		return this;
	}

	public Frete geraAtributosCalculo() {
		return new Frete(distanciaPavimentada, distanciaNaoPavimentada, veiculo, cargaTransportada);
	}
}
