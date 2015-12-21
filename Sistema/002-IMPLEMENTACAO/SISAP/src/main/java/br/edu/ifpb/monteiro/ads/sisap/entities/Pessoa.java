package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;

@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PESSOA", discriminatorType = DiscriminatorType.STRING)
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3385709462485432545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PRIMEIRO_NOME")
	private String primeiroNome;

	@Column(name = "SEGUNDO_NOME")
	private String segundoNome;

	@Column(name = "CPF", unique = true)
	private String cpf;

	@Column(name = "RG", unique = true)
	private String rg;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "GRUPO")
	private String grupo;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	private Sexo sexo;

	@Column(name = "NATURALIDADE", unique = true)
	private String naturalidade;

	@Embedded
	private Endereco endereco;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
	@JoinColumn(name = "CONTATO")
	private List<Contato> contatos;

	@Column(name = "MATRICULA", unique = true)
	private String matriculaSuap;

	@Column(name = "SENHA")
	private String senha;

	public Pessoa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getMatriculaSuap() {
		return matriculaSuap;
	}

	public void setMatriculaSuap(String matriculaSuap) {
		this.matriculaSuap = matriculaSuap;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", primeiroNome=" + primeiroNome
				+ ", segundoNome=" + segundoNome + ", cpf=" + cpf + ", rg="
				+ rg + ", dataNascimento=" + dataNascimento + ", grupo="
				+ grupo + ", sexo=" + sexo + ", naturalidade=" + naturalidade
				+ ", endereco=" + endereco + ", contatos=" + contatos
				+ ", matriculaSuap=" + matriculaSuap + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result
				+ ((primeiroNome == null) ? 0 : primeiroNome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result
				+ ((segundoNome == null) ? 0 : segundoNome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((matriculaSuap == null) ? 0 : matriculaSuap.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (primeiroNome == null) {
			if (other.primeiroNome != null)
				return false;
		} else if (!primeiroNome.equals(other.primeiroNome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (segundoNome == null) {
			if (other.segundoNome != null)
				return false;
		} else if (!segundoNome.equals(other.segundoNome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (matriculaSuap == null) {
			if (other.matriculaSuap != null)
				return false;
		} else if (!matriculaSuap.equals(other.matriculaSuap))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
