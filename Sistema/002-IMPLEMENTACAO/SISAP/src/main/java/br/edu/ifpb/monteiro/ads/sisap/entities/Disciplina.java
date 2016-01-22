package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DISCIPLINA")
@DiscriminatorValue("DISCIPLINA")
public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4519292697947968331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CARGA_HORARIA_EM_HORA_AULA")
	private String cargaHorariaEmHoraAula;

	@Column(name = "CARGA_HORARIA_EM_HORA_RELOGIO")
	private String cargaHorariaEmHoraRelogio;

	@Column(name = "HORARIO")
	private String horario;

	@Column(name = "PERIODO_SERIE")
	private String periodoSerie;

	@Column(name = "DISPONIVEL")
	private Boolean disponivel;

	public Disciplina() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHorariaEmHoraAula() {
		return cargaHorariaEmHoraAula;
	}

	public void setCargaHorariaEmHoraAula(String cargaHorariaEmHoraAula) {
		this.cargaHorariaEmHoraAula = cargaHorariaEmHoraAula;
	}

	public String getCargaHorariaEmHoraRelogio() {
		return cargaHorariaEmHoraRelogio;
	}

	public void setCargaHorariaEmHoraRelogio(String cargaHorariaEmHoraRelogio) {
		this.cargaHorariaEmHoraRelogio = cargaHorariaEmHoraRelogio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPeriodoSerie() {
		return periodoSerie;
	}

	public void setPeriodoSerie(String periodoSerie) {
		this.periodoSerie = periodoSerie;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

}
