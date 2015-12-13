package br.edu.ifpb.monteiro.ads.sisap.service;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class PedagogoService {

	// @Inject
	private PedagogoDAO pedagogoDAO;

	// @TransacionalCdi
	private void addPedagogo(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.salvar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	private Pedagogo editarPedagogo(Pedagogo pedagogo) throws SisapException {
		try {
			return pedagogoDAO.alterar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

//	private void excluirPedagogo(Pedagogo pedagogo) throws SisapException {
//		try {
//			this.pedagogoDAO.deletar(pedagogo);
//		} catch (SisapException exception) {
//			throw new SisapException(exception.getMessage());
//		}
//	}

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
