package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	public void filtrar() {
		try {
			pedagogo = pedagogoService.buscaPorMatricula(matricula);
		} catch (SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
		}
	}

	public void limpar() {
		matricula = null;
	}
	
}
