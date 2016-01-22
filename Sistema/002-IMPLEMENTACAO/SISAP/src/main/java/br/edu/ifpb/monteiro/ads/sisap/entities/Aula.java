package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AULA")
@DiscriminatorValue("AULA")
public class Aula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7065307840278798825L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATA")
	private Date data;

	@Column(name = "CONTEUDO")
	private String conteudo;

	@Column(name = "ALUNOS")
	private ArrayList<Aluno> alunos;

	public Aula() {
		alunos = new ArrayList<Aluno>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

}
