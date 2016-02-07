package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidade Atendimento para que seja realizado o preenchimento da ficha de
 * atendimento referente a uma pessoa que esta sendo atendida no momento.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity(name = "Atendimento")
@Table(name = "TB_ATENDIMENTO")
@DiscriminatorValue("ATENDIMENTO")
public class Atendimento extends Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8244968228387250826L;

	@NotNull(message = "Informe o nome do Atendido")
	private String atendido;

	@Column(name = "SOLICITANTE")
	private String solicitante;

	@Column(name = "MATRICULA_ALUNO")
	private String matriculaAluno;

	@Column(name = "NOME_ALUNO")
	private String nomeAluno;

	@Column(name = "MEDIDAS_ANTERIORES")
	private String medidasAnteriores;

	@Column(name = "MEDIDAS_POSTERIORES")
	private String medidasPosteriores;

	@Column(name = "OBSERVACOES")
	private String observacoes;

	public Atendimento() {
	}

	public String getAtendido() {
		return atendido;
	}

	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
