package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "VisitaDomiciliar")
@Table(name = "TB_VISITA_DOMICILIAR")
@DiscriminatorValue("VISITADOMICILIAR")
public class VisitaDomiciliar extends Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851477081679943116L;

	@Column(name = "MOTIVO")
	private String motivo;

	@Column(name = "ANALISE")
	private String analise;

	@Column(name = "MATRICULA_ALUNO")
	private String matriculaAluno;

	@Column(name = "NOME_ALUNO")
	private String nomeAluno;

	public VisitaDomiciliar() {
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getAnalise() {
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

}
