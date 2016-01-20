package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity (name="Aluno")
@Table(name = "TB_ALUNO")
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long matricula;
	
	private String pai;
	
	private String mae;
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}


	public long getMatricula() {
		return matricula;
	}


	public void setMatricula(long matricula) {
		this.matricula = matricula;
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


	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", pai=" + pai + ", mae="
				+ mae + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result + (int) (matricula ^ (matricula >>> 32));
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
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
		Aluno other = (Aluno) obj;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (matricula != other.matricula)
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		return true;
	}
	
	
}
