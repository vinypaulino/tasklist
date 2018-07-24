package br.com.vinipaulino.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Configuracao {
	
	@Id
	private Integer id;
	
	@Column(nullable = true)
	private double taxaCustoCarga;
	@Column(nullable = true)
	private int toneladaMinima;
	@Column(nullable = true)
	private double valorViaPavimentada;
	@Column(nullable = true)
	private double valorViaNaoPavimentada;

	
	@Transient
	private Configuracao configuracao;
	
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValorViaPavimentada() {
		return valorViaPavimentada;
	}
	public void setValorViaPavimentada(double valorViaPavimentada) {
		this.valorViaPavimentada = valorViaPavimentada;
	}
	public double getValorViaNaoPavimentada() {
		return valorViaNaoPavimentada;
	}
	public void setValorViaNaoPavimentada(double valorViaNaoPavimentada) {
		this.valorViaNaoPavimentada = valorViaNaoPavimentada;
	}
	public double getTaxaCustoCarga() {
		return taxaCustoCarga;
	}
	public void setTaxaCustoCarga(double taxaCustoCarga) {
		this.taxaCustoCarga = taxaCustoCarga;
	}
	public int getToneladaMinima() {
		return toneladaMinima;
	}
	public void setToneladaMinima(int toneladaMinima) {
		this.toneladaMinima = toneladaMinima;
	}

}
