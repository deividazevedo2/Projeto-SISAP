package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Atividade")
@Table(name = "TB_ATIVIDADE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ATV")
@DiscriminatorColumn(name = "TIPO_ATIVIDADE", discriminatorType = DiscriminatorType.STRING)
public class Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@NotNull(message = "Informe a Situacao deste Atendimento")
	private String situacao;

	@NotNull
	// @Pattern(regexp =
	// "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((18|19|20|21)\\d\\d)",
	// message = "Informe a data no formato DD/MM/YYYY")
	private String dataDeAgendamento;

	// @Pattern(regexp =
	// "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((18|19|20|21)\\d\\d)",
	// message = "Informe a data no formato DD/MM/YYYY")
	private String dataDeFinalizacao;

	private String tipoAtividade;

	public Atividade() {
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
