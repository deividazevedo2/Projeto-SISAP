package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/**
 * Entidade Turma onde deve ter todas as caracteristicas de uma turma.
 * 
 * @author Deivid Azevedo
 *
 */
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

	@Column(name = "ANO_PERIODO_LETIVO")
	private String anoPeriodoLetivo;

	@Column(name = "HORARIO")
	private String horario;

	@Column(name = "SALA")
	private String sala;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "turma")
	@IndexColumn(name = "aluno")
	private List<Aluno> alunos;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "turma")
	@IndexColumn(name = "avaliacao")
	private List<Avaliacao> avaliacoes;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "turma")
	@IndexColumn(name = "aula")
	private List<Aula> aulas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DISCIPLINA_FK")
	private Disciplina disciplina;

	public Turma() {
		alunos = new ArrayList<Aluno>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
