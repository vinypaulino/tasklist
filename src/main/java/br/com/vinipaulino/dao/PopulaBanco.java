package br.com.vinipaulino.dao;

import javax.persistence.EntityManager;
import br.com.vinipaulino.modelo.Configuracao;
import br.com.vinipaulino.modelo.Veiculo;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			Veiculo v1 = geraVeiculo("Caminhao Bau", 1.0);
			em.persist(v1);

			Veiculo v2 = geraVeiculo("Caminhao Cacamba", 1.05);
			em.persist(v2);

			Veiculo v3 = geraVeiculo("Carreta", 1.12);
			em.persist(v3);
			
			Configuracao config = geraConfiguracaoInicial();
			em.persist(config);

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("INSERT: " + e.getMessage());
		} finally {
			em.close();
		}
	}

	private static Configuracao geraConfiguracaoInicial() {
		Configuracao config = new Configuracao();
		config.setId(1);
		config.setToneladaMinima(5);
		config.setTaxaCustoCarga(0.02);
		config.setValorViaPavimentada(0.54);
		config.setValorViaNaoPavimentada(0.62);
		return config;
	}

	private static Veiculo geraVeiculo(String tipoVeiculo, Double fatorValor) {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo(tipoVeiculo);
		veiculo.setFatorValor(fatorValor);
		return veiculo;
	}
}
