package br.com.vinipaulino.rn;


import java.util.List;

import br.com.vinipaulino.dao.DAO;
import br.com.vinipaulino.modelo.Veiculo;

public class VeiculoRn {
	
	public VeiculoRn() {	
	}
	
	public void gravarVeiculo(Veiculo veiculo) {
		System.out.println("tipo do Veiculo" + veiculo.getTipoVeiculo());
		if (veiculo.getId() == null) {
	        new DAO<Veiculo>(Veiculo.class).adiciona(veiculo);        
	    } else {
	        new DAO<Veiculo>(Veiculo.class).atualiza(veiculo);
	    }
	}

	public List<Veiculo> getVeiculos() {
		return new DAO<Veiculo>(Veiculo.class).listaTodos();
	}

	public void setVeiculos(List<Veiculo> veiculos) {
	}

	public void remove(Veiculo veiculo) {
		new DAO<Veiculo>(Veiculo.class).remove(veiculo);
	}
	
	public Veiculo getVeiculoPorId(Integer id) {
		return new DAO<Veiculo>(Veiculo.class).buscaPorId(id);
	}
}
