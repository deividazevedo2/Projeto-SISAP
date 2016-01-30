package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "TB_NOTA_DE_AVALIACAO")
@DiscriminatorValue("NOTA_DE_AVALIACAO")
public class NotaDeAvaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4090003640582050955L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ALUNO")
	private Aluno aluno;

	@Column(name = "DISCIPLINA")
	private Disciplina disciplina;

	@Column(name = "NOTA")
	private Float nota;

	@Column(name = "COMENTARIO")
	private String comentario;
	
//	@Column
//	private Avaliacao avaliacao;


//	@OneToMany(fetch= FetchType.EAGER)
	@JoinTable(name="AVALICAO")
	private Avaliacao avaliacao;
	
	public NotaDeAvaliacao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
