package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Aluno")
@Table(name = "TB_ALUNO")
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long matricula;

	private String pai;

	private String mae;

	public Aluno() {
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

}
