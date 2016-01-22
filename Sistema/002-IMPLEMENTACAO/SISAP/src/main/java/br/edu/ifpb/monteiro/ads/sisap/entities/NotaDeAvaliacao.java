package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NOTA_DE_AVALIACAO")
@DiscriminatorValue("NOTA_DE_AVALIACAO")
public class NotaDeAvaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4090003640582050955L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOTA")
	private Float nota;

	@Column(name = "COMENTARIO")
	private String comentario;

	public NotaDeAvaliacao() {
	}
}
