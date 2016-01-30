package br.edu.ifpb.monteiro.ads.sisap.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

//	@Column(name = "ASSUNTO")
//	private Aula assunto;

//	@Column(name = "NOTA")
//	private List<NotaDeAvaliacao> notas;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ASSUNTO")
	private Aula assunto;

	@OneToMany(fetch= FetchType.EAGER)
	@JoinTable(name="NOTAS_AVALICAO", joinColumns={@JoinColumn(name="AVALICAO_ID", referencedColumnName="ID")},inverseJoinColumns={@JoinColumn(name="NOTA_DE_AVALIACAO_ID", referencedColumnName="ID")})
	private List<NotaDeAvaliacao> notas;

	public Avaliacao() {
	}
	
	 

}
