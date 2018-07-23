package br.com.vinipaulino.rn;

import br.com.vinipaulino.modelo.Configuracao;
import br.com.vinipaulino.modelo.Frete;

public class CalculoFreteRn {
	private Frete frete;
	private double custoPercurso;
	private Configuracao config;
	private int pesoExcedido;

	public CalculoFreteRn(Frete frete, Configuracao config) {
		this.frete = frete;
		this.config = config;
	}

	public double calculaFrete() {
		
		if (frete.getDistanciaPavimentada() > 0) {
			custoPercurso = calculaDistanciaPavimentada();
		}

		if (frete.getDistanciaNaoPavimentada() > 0) {
			custoPercurso += calculaDistanciaNaoPavimentada();
		}
		
		custoPercurso = calculaCustoPorValorVeiculo();
		
		if (frete.getCargaTransportada() > config.getToneladaMinima()) {
			 pesoExcedido = frete.getCargaTransportada() - config.getToneladaMinima();
			 custoPercurso += caculaCustoPesoExcedido();
		} 
		 
		return custoPercurso;
	}

	private double calculaCustoPorValorVeiculo() {
		return custoPercurso * frete.getVeiculo().getFatorValor();
	}

	private double caculaCustoPesoExcedido() {
		return (pesoExcedido * config.getTaxaCustoCarga()) * (frete.getDistanciaPavimentada() + frete.getDistanciaNaoPavimentada());
	}

	private double calculaDistanciaNaoPavimentada() {
		return frete.getDistanciaNaoPavimentada() * config.getValorViaNaoPavimentada();
	}

	private double calculaDistanciaPavimentada() {
		return frete.getDistanciaPavimentada() * config.getValorViaPavimentada();
	}

	public Frete getCalculoFrete() {
		return frete;
	}

	public void setCalculoFrete(Frete frete) {
		this.frete = frete;
	}
	
}
