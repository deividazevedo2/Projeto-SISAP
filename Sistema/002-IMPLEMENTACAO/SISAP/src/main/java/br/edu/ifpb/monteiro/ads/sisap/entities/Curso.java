package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Curso, onde devera conter todas as informacoes acerca do curso que
 * sera cadastrado, tais como CODIGO, SIGLA, TURNO, DURACAO EM MESES, etc.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity(name = "Curso")
@Table(name = "TC_CURSO")
@DiscriminatorValue("CURSO")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 982689346153639395L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "SIGLA")
	private String sigla;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DURACAO_MESES")
	private Short duracaoMeses;

	@Column(name = "TURNO") 
	private Turno turno;

	public Curso() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Short getDuracaoMeses() {
		return duracaoMeses;
	}

	public void setDuracaoMeses(Short duracaoMeses) {
		this.duracaoMeses = duracaoMeses;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
