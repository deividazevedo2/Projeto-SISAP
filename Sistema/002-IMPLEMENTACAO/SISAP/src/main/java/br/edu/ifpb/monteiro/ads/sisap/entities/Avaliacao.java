package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/**
 * Entidade Avaliacao para informar a DATA de realizacao da avaliacao, o ASSUNTO
 * dela, e as notas de cada avaliacao. As notas da avaliacao deverao estar em
 * outra tabela, onde serao referenciados o ID da avaliacao e o ID do aluno com
 * a sua nota na avaliacao.
 * 
 * @author Deivid Azevedo
 *
 */
@Entity(name = "Avaliacao")
@Table(name = "TB_AVALIACAO")
@DiscriminatorValue("AVALIACAO")
public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1217599482114830288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATA")
	private Date data;

	@Column(name = "ASSUNTO")
	private String assunto;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "avaliacao")
	@IndexColumn(name = "nota")
	private transient List<NotaDeAvaliacao> notas;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TURMA_FK", nullable = false)
	private transient Turma turma;

	public Avaliacao() {
		notas = new ArrayList<NotaDeAvaliacao>();
	}

}
