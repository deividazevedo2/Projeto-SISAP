package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TURMA")
@DiscriminatorValue("TURMA")
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8184311990618009592L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ALUNOS")
	private ArrayList<Aluno> alunos;

	@Column(name = "ANO_PERIODO_LETIVO")
	private String anoPeriodoLetivo;

	@Column(name = "HORARIO")
	private String horario;

	@Column(name = "SALA")
	private String sala;

	@Column(name = "AVALIACOES")
	private ArrayList<Avaliacao> avaliacoes;

	
	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getAnoPeriodoLetivo() {
		return anoPeriodoLetivo;
	}

	public void setAnoPeriodoLetivo(String anoPeriodoLetivo) {
		this.anoPeriodoLetivo = anoPeriodoLetivo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	

}
