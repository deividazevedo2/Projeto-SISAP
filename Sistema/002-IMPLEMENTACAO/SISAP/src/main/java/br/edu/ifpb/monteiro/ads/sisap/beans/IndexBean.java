package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@RequestScoped
public class IndexBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8838451015814331503L;

	private static final Log LOGGER = LogFactory.getLog(IndexBean.class);

	private Pedagogo pedagogo = new Pedagogo();

	private List<Pedagogo> pedagogos;

	@Inject
	private PedagogoService pedagogoService;

	private String nomePedagogo;
	private String matriculaPedagogo;

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public PedagogoService getPedagogoService() {
		return pedagogoService;
	}

	public void setPedagogoService(PedagogoService pedagogoService) {
		this.pedagogoService = pedagogoService;
	}

	@PostConstruct
	public void init() {
		filtrar();
	}

	/**
	 * Metodo para realizar a filtragem dos cadastros de pedagogo, por
	 * matricula.
	 */
	public void filtrar() {
		try {
			pedagogo = pedagogoService.buscarPorMatricula(matriculaPedagogo);
			pedagogos = pedagogoService.getAll(matriculaPedagogo, nomePedagogo);
		} catch (RollbackException | SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			LOGGER.warn("Erro ao filtrar", exception);
		}
	}

	public List<Pedagogo> getPedagogos() {
		return pedagogos;
	}

	public void setPedagogos(List<Pedagogo> pedagogos) {
		this.pedagogos = pedagogos;
	}

	public String getNomePedagogo() {
		return nomePedagogo;
	}

	public void setNomePedagogo(String nomePedagogo) {
		this.nomePedagogo = nomePedagogo;
	}

	public String getMatriculaPedagogo() {
		return matriculaPedagogo;
	}

	public void setMatriculaPedagogo(String matriculaPedagogo) {
		this.matriculaPedagogo = matriculaPedagogo;
	}

	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

	/**
	 * Limpar o campo.
	 */
	public void limpar() {
		matriculaPedagogo = null;
	}

}
