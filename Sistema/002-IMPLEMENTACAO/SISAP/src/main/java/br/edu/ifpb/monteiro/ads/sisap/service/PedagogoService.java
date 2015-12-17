package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class PedagogoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private PedagogoDAO pedagogoDAO;

	@TransacionalCdi
	public void addPedagogo(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.salvar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@TransacionalCdi
	public Pedagogo editarPedagogo(Pedagogo pedagogo) throws SisapException {
		try {
			return pedagogoDAO.alterar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

	@TransacionalCdi
	public void excluirPedagogo(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.deletar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

	@TransacionalCdi
	public Pedagogo buscaPorMatricula(String matricula) throws SisapException {
		try {
			return this.pedagogoDAO.buscarPorMatricula(matricula);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}

	}

	public Pedagogo getById(Long idPedagogo) throws SisapException {
		try {
			return this.pedagogoDAO.buscar(idPedagogo);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}

	}

}
