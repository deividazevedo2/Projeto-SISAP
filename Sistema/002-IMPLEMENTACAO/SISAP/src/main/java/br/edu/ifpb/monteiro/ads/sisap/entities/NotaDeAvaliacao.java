package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NOTA_DE_AVALIACAO")
@DiscriminatorValue("NOTA_DE_AVALIACAO")
public class NotaDeAvaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4090003640582050955L;

	private Long id;
	
	private Float nota;
	
	private String comentario;
	
	
	
}
