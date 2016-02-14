package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;

/**
 * Classe Entidade ALUNO que servira para salvar as informacoes do aluno que
 * virao da base de dados.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity(name = "Aluno")
@Table(name = "TB_ALUNO")
@DiscriminatorValue("ALUNO")
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "MATRICULA", unique = true)
	private String matricula;

	private String nome;

	@Embedded
	private Endereco endereco;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTATO_FK", nullable = false)
	private Contato contato;

	private String pai;

	private String mae;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RESPONSAVEL_FK", nullable = false)
	private Responsavel responsavel;

	@ManyToMany
	@JoinTable(name = "Bimestres_aluno", joinColumns = @JoinColumn(name = "id_aluno"), inverseJoinColumns = @JoinColumn(name = "id_bimestre"))
	private List<Bimestre> bimestres;

	public Aluno() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Bimestre> getBimestres() {
		return bimestres;
	}

	public void setBimestres(List<Bimestre> bimestres) {
		this.bimestres = bimestres;
	}

}
