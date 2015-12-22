package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;
import br.edu.ifpb.monteiro.ads.sisap.validator.Validador;

public class PedagogoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedagogoDAO pedagogoDAO;
	private Validador validador;

	public PedagogoService() {
		validador = new Validador();
	}

	@TransacionalCdi
	public void salvar(Pedagogo pedagogo) throws SisapException {
		try {
			validador.ValidarCamposPedagogo(pedagogo);
			this.pedagogoDAO.salvar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@TransacionalCdi
	public Pedagogo atualizar(Pedagogo pedagogo) throws SisapException {
		try {
			validador.ValidarCamposPedagogo(pedagogo);
			return pedagogoDAO.atualizar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

	@TransacionalCdi
	public void remover(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.remover(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@TransacionalCdi
	public Pedagogo buscarPorId(Long idPedagogo) throws SisapException {
		try {
			return this.pedagogoDAO.buscarPorId(idPedagogo);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}
	}

	@TransacionalCdi
	public Pedagogo buscarPorMatricula(String matricula) throws SisapException {
		try {
			return ((PedagogoDAO) this.pedagogoDAO)
					.buscarPorMatricula(matricula);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}

	}

}
