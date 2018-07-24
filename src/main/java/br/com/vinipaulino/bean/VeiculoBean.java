package br.com.vinipaulino.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.vinipaulino.modelo.Veiculo;
import br.com.vinipaulino.rn.VeiculoRn;

@ManagedBean
@ViewScoped
public class VeiculoBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private VeiculoRn veiculoRn;
	private Veiculo veiculo = new Veiculo();
	
	
	public VeiculoBean() {
		this.veiculoRn = new VeiculoRn();
	}
	
	public void gravar() {		
		veiculoRn.gravarVeiculo(this.veiculo);	
		this.veiculo = new Veiculo();
	}
	
	public void carregar(Veiculo veiculo) {
	    System.out.println("Carregando livro " + veiculo.getTipoVeiculo());
	    this.veiculo = veiculo;
	}
	
	public void remover(Veiculo veiculo) {
	    System.out.println("Removendo veiculo " + veiculo.getTipoVeiculo());
	    veiculoRn.remove(veiculo); 
	  
	}
	
	public List<Veiculo> getVeiculos(){
		return veiculoRn.getVeiculos();
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
