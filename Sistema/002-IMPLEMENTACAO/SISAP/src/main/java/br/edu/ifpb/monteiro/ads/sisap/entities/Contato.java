package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * Entidade Contato, onde devera conter todos os contatos necessarios para uma
 * pessoa (aluno, responsavel, Professor, etc).
 * 
 * @author Deivid Azevedo
 *
 */
@Entity
@Table(name = "TB_CONTATO")
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4151821226815105871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String telefoneResidencial;

	private String telefoneTrabalho;

	@Length(min = 10, max = 14, message = "Celular Invalido!")
	private String celular;

	private String facebok;

	private String twitter;

	// Pattern para definir o padrao de um e-mail a ser inserido no cadastro.
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$", message = "Email Invalido!")
	private String email;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "contato")
	private Pessoa pessoa;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "contato")
	private Responsavel responsavel;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "contato")
	private Aluno aluno;

	public Contato() {
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneTrabalho() {
		return telefoneTrabalho;
	}

	public void setTelefoneTrabalho(String telefoneTrabalho) {
		this.telefoneTrabalho = telefoneTrabalho;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFacebok() {
		return facebok;
	}

	public void setFacebok(String facebok) {
		this.facebok = facebok;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
