package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Avaliacao")
@Table(name = "TB_AVALIACAO")
@DiscriminatorValue("AVALIACAO")
public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1217599482114830288L;
	
	
	@Column(name="DATA")
	private Date data;
	
	@Column(name="ASSUNTO")
	private Aula assunto;
	
	
	

}
