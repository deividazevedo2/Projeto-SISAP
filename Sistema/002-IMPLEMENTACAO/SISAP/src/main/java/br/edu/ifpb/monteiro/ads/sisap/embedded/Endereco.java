package br.edu.ifpb.monteiro.ads.sisap.embedded;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class Endereco {

	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	
	@Pattern(regexp="[0-9]{5}-[0-9]{3}", message = "CEP Invalido!")
	private String cep;
	private String uf;

	public Endereco() {
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
