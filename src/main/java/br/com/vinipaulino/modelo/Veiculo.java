package br.com.vinipaulino.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String tipoVeiculo;
	
	@Column(nullable = false)
	private double fatorValor;

	public Veiculo() {
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public double getFatorValor() {
		return fatorValor;
	}

	public void setFatorValor(double fatorValor) {
		this.fatorValor = fatorValor;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", tipoVeiculo=" + tipoVeiculo + ", fatorValor=" + fatorValor + "]";
	}
	
	
}