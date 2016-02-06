package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Visita_domiciliar")
@Table(name = "TB_VISITA_DOMICILIAR")
@DiscriminatorValue("VISITA_DOMICILIAR")
public class VisitaDomiciliar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851477081679943116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ALUNO_FK")
	private Aluno aluno;

	@Column(name = "DATA_AGENDAMENTO")
	private String dataDeAgendamento;

	@Column(name = "DATA_FINALIZACAO")
	private String dataDeFinalizacao;

	@NotNull
	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "SITUACAO")
	private String situacao;

	@Column(name = "MOTIVO")
	private String motivo;

	@Column(name = "ANALISE")
	private String analise;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataDeAgendamento() {
		return dataDeAgendamento;
	}

	public void setDataDeAgendamento(String dataDeAgendamento) {
		this.dataDeAgendamento = dataDeAgendamento;
	}

	public String getDataDeFinalizacao() {
		return dataDeFinalizacao;
	}

	public void setDataDeFinalizacao(String dataDeFinalizacao) {
		this.dataDeFinalizacao = dataDeFinalizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
