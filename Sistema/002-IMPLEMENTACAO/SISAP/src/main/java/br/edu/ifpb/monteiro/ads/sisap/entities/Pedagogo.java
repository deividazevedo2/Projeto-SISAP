package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDAGOGO")
@DiscriminatorValue("PEDAGOGO")
public class Pedagogo extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222738149854183983L;

	@Column(name = "MATRICULA", unique = true)
	private String matriculaSuap;

	@Column(name = "SENHA")
	private String senha;

	public Pedagogo() {
	}

	public String getMatriculaSuap() {
		return matriculaSuap;
	}

	public void setMatriculaSuap(String matriculaSuap) {
		this.matriculaSuap = matriculaSuap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((matriculaSuap == null) ? 0 : matriculaSuap.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedagogo other = (Pedagogo) obj;
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
