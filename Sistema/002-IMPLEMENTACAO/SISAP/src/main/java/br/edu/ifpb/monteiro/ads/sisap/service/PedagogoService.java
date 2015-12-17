package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.sisap.interfaces.ServiceIF;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class PedagogoService extends Service<Pedagogo> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DaoIF<Pedagogo> pedagogoDAO;
//	private PedagogoDAO pedagogoDAO;

	
	
	@Override
	@TransacionalCdi
	public void salvar(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.salvar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	public DaoIF<Pedagogo> getPedagogoDAO() {
		return pedagogoDAO;
	}

	public void setPedagogoDAO(DaoIF<Pedagogo> pedagogoDAO) {
		this.pedagogoDAO = pedagogoDAO;
	}

	@Override
	@TransacionalCdi
	public Pedagogo atualizar(Pedagogo pedagogo) throws SisapException {
		try {
			return pedagogoDAO.atualizar(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

	@Override
	@TransacionalCdi
	public void remover(Pedagogo pedagogo) throws SisapException {
		try {
			this.pedagogoDAO.remover(pedagogo);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@Override
	@TransacionalCdi
	public Pedagogo consultarPorId(Long idPedagogo) throws SisapException {
		try {
			return this.pedagogoDAO.buscaPorId(idPedagogo);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}
	}

	@TransacionalCdi
	public Pedagogo buscaPorMatricula(String matricula) throws SisapException {
		try {
			return ((PedagogoDAO) this.pedagogoDAO).buscarPorMatricula(matricula);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}

	}

}
