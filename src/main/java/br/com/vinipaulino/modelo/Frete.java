package br.com.vinipaulino.modelo;

public final class Frete {

	private final double distanciaPavimentada;
	private final double distanciaNaoPavimentada;
	private final Veiculo veiculo;
	private final int cargaTransportada;
	private double custoTransporte;

	public Frete(double distanciaPavimentada, double distanciaNaoPavimentada, Veiculo veiculo,
			int cargaTransportada) {


		this.distanciaPavimentada = distanciaPavimentada;
		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
		this.veiculo = veiculo;
		this.cargaTransportada = cargaTransportada;

		validaDistancia();
		validaCargaTransportada();
		validaVeiculo();
	}

	private void validaVeiculo() {
		if (veiculo == null) {
			throw new IllegalArgumentException("Não é possivel criar o calculo com veiculo nullo");
		}
	
	}

	private void validaCargaTransportada() {
		if (cargaTransportada < 1) {
			throw new IllegalArgumentException("Não é possivel criar calculo sem o peso da carga a ser transportada");
		}

	}

	private void validaDistancia() {
		if ((distanciaPavimentada <= 0) && (distanciaNaoPavimentada <= 0)) {
			throw new IllegalArgumentException("Não é possivel criar o Calculo sem distancia");
		}
	}

	public double getDistanciaPavimentada() {
		return distanciaPavimentada;
	}

	public double getDistanciaNaoPavimentada() {
		return distanciaNaoPavimentada;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public int getCargaTransportada() {
		return cargaTransportada;
	}

	public double getCustoTransporte() {
		return custoTransporte;
	}

}