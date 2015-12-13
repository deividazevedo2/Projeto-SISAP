package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDAGOGO")
@DiscriminatorValue("P")
public class Pedagogo extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222738149854183983L;

	@Id
	@Column(name = "ID")
	private Long id;

	private String matriculaSuap;

	private Conta conta;
	

	public Pedagogo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((matriculaSuap == null) ? 0 : matriculaSuap.hashCode());
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
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matriculaSuap == null) {
			if (other.matriculaSuap != null)
				return false;
		} else if (!matriculaSuap.equals(other.matriculaSuap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedagogo [id=" + id + ", matriculaSuap=" + matriculaSuap
				+ ", conta=" + conta + "]";
	}

	
}
