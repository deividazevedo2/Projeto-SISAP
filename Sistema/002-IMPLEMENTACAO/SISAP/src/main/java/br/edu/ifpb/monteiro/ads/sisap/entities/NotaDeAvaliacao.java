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
 * Classe onde serao salvas as notas de cada avaliacao do aluno. Onde serao
 * armazenadas as seguintes informacoes: referencia do aluno, nota deste,
 * disciplina da avaliacao, e comentario que possa vir a ser informado para
 * alguma observacao acerca desta nota.
 * 
 * @author Deivid Azevedo
 *
 */
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
	private Integer id;

	@Column(name = "NOTA")
	private Double nota;

	@Column(name = "COMENTARIO")
	private String comentario;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ALUNO_FK", nullable = false)
	private Aluno aluno;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DISCIPLINA_FK", nullable = false)
	private Disciplina disciplina;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "AVALIACAO_FK", nullable = false)
	private Avaliacao avaliacao;

	public NotaDeAvaliacao() {
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
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
