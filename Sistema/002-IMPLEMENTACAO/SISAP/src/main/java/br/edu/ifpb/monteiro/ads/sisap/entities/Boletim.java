package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Boletim")
@Table(name = "TB_BOLETIM")
@DiscriminatorValue("BOLETIM")
public class Boletim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8590832326707244169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	private String matricula;

	private String disciplina;

	private Double notaPrimeiroBimestre;

	private Double notaSegundoBimestre;

	private Double notaTerceiroBimestre;

	private Double notaQuartoBimestre;

	private Double mediaDisciplina;

	public Boletim() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNotaPrimeiroBimestre() {
		return notaPrimeiroBimestre;
	}

	public void setNotaPrimeiroBimestre(Double notaPrimeiroBimestre) {
		this.notaPrimeiroBimestre = notaPrimeiroBimestre;
	}

	public Double getNotaSegundoBimestre() {
		return notaSegundoBimestre;
	}

	public void setNotaSegundoBimestre(Double notaSegundoBimestre) {
		this.notaSegundoBimestre = notaSegundoBimestre;
	}

	public Double getNotaTerceiroBimestre() {
		return notaTerceiroBimestre;
	}

	public void setNotaTerceiroBimestre(Double notaTerceiroBimestre) {
		this.notaTerceiroBimestre = notaTerceiroBimestre;
	}

	public Double getNotaQuartoBimestre() {
		return notaQuartoBimestre;
	}

	public void setNotaQuartoBimestre(Double notaQuartoBimestre) {
		this.notaQuartoBimestre = notaQuartoBimestre;
	}

	public Double getMediaDisciplina() {
		return mediaDisciplina;
	}

	public void setMediaDisciplina(Double mediaDisciplina) {
		this.mediaDisciplina = mediaDisciplina;
	}
}
