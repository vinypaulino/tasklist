package br.com.vinipaulino.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	
	private String descricao; 
		
	private Boolean statusConcluido = false;
	@Transient
	private String statusString;

	public Task() {
	}
	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatusConcluido() {
		return statusConcluido;
	}

	public void setStatusConcluido(Boolean statusConcluido) {
		this.statusConcluido = statusConcluido;
	}
	
	public String getStatusString() {
		if (this.getStatusConcluido() == false ) {
			return "Status: Em Aberto";
		} else {
			return "Status: Concluido";
		}
	}
}
