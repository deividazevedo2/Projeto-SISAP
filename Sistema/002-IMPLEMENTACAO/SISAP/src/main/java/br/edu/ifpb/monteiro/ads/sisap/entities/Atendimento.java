package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidade Atendimento para que seja realizado o preenchimento da ficha de
 * atendimento referente a uma pessoa que esta sendo atendida no momento.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity
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
	private Long id;

	private String atendido;

	@Column(name = "SOLICITANTE")
	private String solicitante;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ALUNO_FK", nullable = false)
	private Aluno aluno;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "MEDIDAS_ANTERIORES")
	private String medidasAnteriores;

	@Column(name = "MEDIDAS_POSTERIORES")
	private String medidasPosteriores;

	@Column(name = "ENCAMINHADO")
	private Boolean encaminhado;

	@Column(name = "NOTIFICACAO_ENVIADA")
	private Boolean notificacaoEnviada;

	@Column(name = "OBSERVACOES")
	private String observacoes;

	public Atendimento() {
		encaminhado = false;
		notificacaoEnviada = false;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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

	public Boolean getEncaminhado() {
		return encaminhado;
	}

	public void setEncaminhado(Boolean encaminhado) {
		this.encaminhado = encaminhado;
	}

	public Boolean getNotificacaoEnviada() {
		return notificacaoEnviada;
	}

	public void setNotificacaoEnviada(Boolean notificacaoEnviada) {
		this.notificacaoEnviada = notificacaoEnviada;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
