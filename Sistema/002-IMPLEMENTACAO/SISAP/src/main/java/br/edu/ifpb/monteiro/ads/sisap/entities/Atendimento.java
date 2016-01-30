package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "Atendimento")
@Table(name = "TB_ATENDIMENTO")
@DiscriminatorValue("ATENDIMENTO")
public class Atendimento implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1497141210903425799L;

	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name="ATENDIDO") 
	private List<Pessoa> atendido;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PESSOA_FK", nullable = false)
	private Pessoa solicitante;
	
	@Column(name = "MEDIDAS_ANTERIORES")
	private String medidasAnteriores;
	
	@Column(name = "MEDIDAS_POSTERIORES")
	private String medidasPosteriores;
	
	public Atendimento() {
		// TODO Auto-generated constructor stub
	}

	public List<Pessoa> getAtendido() {
		return atendido;
	}

	public void setAtendido(List<Pessoa> atendido) {
		this.atendido = atendido;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	public String getMedidasAnteriores() {
		return medidasAnteriores;
	}

	public void setMedidasAnteriores(String medidasAnteriores) {
		this.medidasAnteriores = medidasAnteriores;
	}

	public String getMedidasPosteriores() {
		return medidasPosteriores;
	}

	public void setMedidasPosteriores(String medidasPosteriores) {
		this.medidasPosteriores = medidasPosteriores;
	}
	
	
	

}
