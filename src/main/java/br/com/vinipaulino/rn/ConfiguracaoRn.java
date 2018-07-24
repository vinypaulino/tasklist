package br.com.vinipaulino.rn;

import br.com.vinipaulino.dao.DAO;
import br.com.vinipaulino.modelo.Configuracao;


public class ConfiguracaoRn {

	public Configuracao getConfiguracaoInicial() {
		//Retorna Sempre A configuracao inicial de Id 1
		return new DAO<Configuracao>(Configuracao.class).buscaPorId(1);
	}
}
