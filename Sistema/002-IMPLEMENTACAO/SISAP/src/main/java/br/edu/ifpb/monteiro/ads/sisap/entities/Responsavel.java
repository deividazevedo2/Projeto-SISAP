package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;

/**
 * Entidade Responsavel que devera ser vinculado ao cadastro de Aluno para que
 * seja realizado um atendimento a este.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity
@Table(name = "TB_RESPONSAVEL")
public class Responsavel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2218951723434527581L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTATO_FK", nullable = false)
	private Contato contato;

	@Embedded
	private Endereco endereco;

	@Column(name = "GRAU_DE_PARENTESCO")
	private String grauDeParentesco;

	@Column(name = "GRAU_DE_INSTRUCAO")
	private String grauDeInstrucao;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "responsavel")
	private transient Aluno aluno;

	public Responsavel() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}

	public String getGrauDeInstrucao() {
		return grauDeInstrucao;
	}

	public void setGrauDeInstrucao(String grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
