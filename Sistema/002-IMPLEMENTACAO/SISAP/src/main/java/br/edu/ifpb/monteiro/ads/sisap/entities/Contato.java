package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TB_CONTATO")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String telefoneResidencial;

	private String telefoneTrabalho;

	@Length(min = 10, max = 14, message = "Celular Invalido!")
	private String celular;

	private String facebok;

	private String twitter;

	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$", message = "Email Invalido!")
	private String email;

	public Contato() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facebok == null) ? 0 : facebok.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((telefoneResidencial == null) ? 0 : telefoneResidencial
						.hashCode());
		result = prime
				* result
				+ ((telefoneTrabalho == null) ? 0 : telefoneTrabalho.hashCode());
		result = prime * result + ((twitter == null) ? 0 : twitter.hashCode());
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
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebok == null) {
			if (other.facebok != null)
				return false;
		} else if (!facebok.equals(other.facebok))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		if (telefoneTrabalho == null) {
			if (other.telefoneTrabalho != null)
				return false;
		} else if (!telefoneTrabalho.equals(other.telefoneTrabalho))
			return false;
		if (twitter == null) {
			if (other.twitter != null)
				return false;
		} else if (!twitter.equals(other.twitter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", telefoneResidencial="
				+ telefoneResidencial + ", telefoneTrabalho="
				+ telefoneTrabalho + ", celular=" + celular + ", facebok="
				+ facebok + ", twitter=" + twitter + ", email=" + email + "]";
	}

}
