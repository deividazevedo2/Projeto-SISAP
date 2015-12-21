package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROFESSOR")
@DiscriminatorValue("PROFESSOR")
public class Professor extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222738149854183983L;

	public Professor() {
	}

}
