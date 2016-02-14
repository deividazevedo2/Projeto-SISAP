package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Bimestre")
@Table(name = "TB_BIMESTRE")
@DiscriminatorValue("BIMESTRE")
public class Bimestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8590832326707244169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	private String matricula;

	private Double portugues;

	private Double matematica;

	private Double historia;

	private Double artes;

	private Double biologia;

	private Double geografia;

	private Double filosofia;

	private Double fisica;

	private Double quimica;

	private Double sociologia;

	public Bimestre() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getPortugues() {
		return portugues;
	}

	public void setPortugues(Double portugues) {
		this.portugues = portugues;
	}

	public Double getMatematica() {
		return matematica;
	}

	public void setMatematica(Double matematica) {
		this.matematica = matematica;
	}

	public Double getHistoria() {
		return historia;
	}

	public void setHistoria(Double historia) {
		this.historia = historia;
	}

	public Double getArtes() {
		return artes;
	}

	public void setArtes(Double artes) {
		this.artes = artes;
	}

	public Double getBiologia() {
		return biologia;
	}

	public void setBiologia(Double biologia) {
		this.biologia = biologia;
	}

	public Double getGeografia() {
		return geografia;
	}

	public void setGeografia(Double geografia) {
		this.geografia = geografia;
	}

	public Double getFilosofia() {
		return filosofia;
	}

	public void setFilosofia(Double filosofia) {
		this.filosofia = filosofia;
	}

	public Double getFisica() {
		return fisica;
	}

	public void setFisica(Double fisica) {
		this.fisica = fisica;
	}

	public Double getQuimica() {
		return quimica;
	}

	public void setQuimica(Double quimica) {
		this.quimica = quimica;
	}

	public Double getSociologia() {
		return sociologia;
	}

	public void setSociologia(Double sociologia) {
		this.sociologia = sociologia;
	}

}
