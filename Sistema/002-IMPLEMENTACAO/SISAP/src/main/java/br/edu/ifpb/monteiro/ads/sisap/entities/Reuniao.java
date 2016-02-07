package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Reuniao")
@Table(name = "TB_REUNIAO")
@DiscriminatorValue("REUNIAO")
public class Reuniao extends Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 868230619382429815L;

	@NotNull(message = "Informe o objetivo da Reuniao!")
	private String objetivo;

	private String pauta;

	@NotNull(message = "Informe o Solicitante da Reuniao!")
	private String solicitante;

	public Reuniao() {
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

}
