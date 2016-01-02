package br.edu.ifpb.monteiro.ads.sisap.beans;

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

	private Pedagogo pedagogo;

	@Inject
	private PedagogoService pedagogoService;

	private String matricula;

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
			pedagogo = pedagogoService.buscarPorMatricula(matricula);
		} catch (RollbackException | SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			LOGGER.warn("Erro ao filtrar", exception);
		}
	}

	/**
	 * Limpar o campo.
	 */
	public void limpar() {
		matricula = null;
	}

}
