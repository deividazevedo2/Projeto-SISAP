package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Atendimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8244968228387250826L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@NotNull(message = "Informe o nome do Atendido")
	private String atendido;

	@NotNull
	// @Pattern(regexp =
	// "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((18|19|20|21)\\d\\d)",
	// message = "Informe a data no formato DD/MM/YYYY")
	private String data;

	@Column(name = "SOLICITANTE")
	private String solicitante;

	@Column(name = "DESCRICAO")
	private String descricao;

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

	@NotNull(message = "Informe a Situacao deste Atendimento")
	private String situacao;

	public Atendimento() {
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
