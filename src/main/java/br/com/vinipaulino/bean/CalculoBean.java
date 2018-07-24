package br.com.vinipaulino.bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vinipaulino.modelo.Configuracao;
import br.com.vinipaulino.modelo.Frete;
import br.com.vinipaulino.modelo.FreteBuilder;
import br.com.vinipaulino.modelo.Veiculo;
import br.com.vinipaulino.rn.CalculoFreteRn;
import br.com.vinipaulino.rn.ConfiguracaoRn;
import br.com.vinipaulino.rn.VeiculoRn;

@ManagedBean
@ViewScoped
public class CalculoBean {

	private Integer veiculoId;
	private VeiculoRn veiculoRn;
	private double distanciaPavimentada;
	private double distanciaNaoPavimentada;
	private Integer pesoCargaTransportada = 0;
	private String valorCusto = "";
	private Veiculo veiculo;
	private Frete frete;
	private CalculoFreteRn calculador;
	private Configuracao config;
	private ConfiguracaoRn configRn;
	
	public CalculoBean() {
		veiculoRn = new VeiculoRn();
		configRn = new ConfiguracaoRn();
	}

	public void calcular() {
		config = configRn.getConfiguracaoInicial();
		FreteBuilder builderFrete = new FreteBuilder();
		veiculo = veiculoRn.getVeiculoPorId(this.veiculoId);
	    frete = builderFrete.comDistanciaPavimentada(this.distanciaPavimentada).comDistanciaNaoPavimentada(this.distanciaNaoPavimentada)
	    		.comVeiculo(veiculo).comCargaTranportada(this.pesoCargaTransportada).geraAtributosCalculo();

	    calculador = new CalculoFreteRn(frete, config);
	    double valorFrete = calculador.calculaFrete();
	    NumberFormat formatter = new DecimalFormat("#0.00");
	        
	    this.setValorCusto("O valor do custo calculado é de: R$ "+String.valueOf(formatter.format(valorFrete)));
	}

	public double getDistanciaNaoPavimentada() {
		return distanciaNaoPavimentada;
	}

	public void setDistanciaNaoPavimentada(double distanciaNaoPavimentada) {
		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public List<Veiculo> getVeiculos() {
		return veiculoRn.getVeiculos();
	}

	public void setVeiculos(List<Veiculo> veiculos) {
	}

	public double getDistanciaPavimentada() {
		return distanciaPavimentada;
	}

	public void setDistanciaPavimentada(double distanciaPavimentada) {
		this.distanciaPavimentada = distanciaPavimentada;
	}

	public Integer getPesoCargaTransportada() {
		return pesoCargaTransportada;
	}

	public void setPesoCargaTransportada(Integer pesoCargaTransportada) {
		this.pesoCargaTransportada = pesoCargaTransportada;
	}

	public String getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(String valorCusto) {
		this.valorCusto = valorCusto;
	}
}
