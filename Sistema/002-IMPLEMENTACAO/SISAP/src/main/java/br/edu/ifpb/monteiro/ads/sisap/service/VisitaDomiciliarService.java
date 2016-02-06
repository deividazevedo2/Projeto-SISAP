package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.VisitaDomiciliarDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.VisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class VisitaDomiciliarService implements Serializable {

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private VisitaDomiciliarDAO visitaDomiciliarDAO;

	public VisitaDomiciliarDAO getVisitaDomiciliarDAO() {
		return visitaDomiciliarDAO;
	}

	public void setVisitaDomiciliarDAO(VisitaDomiciliarDAO visitaDomiciliarDAO) {
		this.visitaDomiciliarDAO = visitaDomiciliarDAO;
	}

	/**
	 * Metodo para salvar um novo atendimento, chamando a classe atendimentoDAO
	 * onde o registro desta ficha de atendimento devera ser salva no banco de
	 * dados da aplicação..
	 * 
	 * @param atendimento
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void salvar(VisitaDomiciliar visitaDomiciliar) throws SisapException {
		this.visitaDomiciliarDAO.salvar(visitaDomiciliar);

	}

	/**
	 * Este metodo atualiza um determinado atendimento que esta sendo passado
	 * como parametro. Sera chamado o atendimentoDAO que fara a busca no banco e
	 * ira alterar os dados que foram modificados na ficha do atendimento.
	 * 
	 * @param atendimento
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public VisitaDomiciliar atualizar(VisitaDomiciliar visitaDomiciliar)
			throws SisapException {
		return visitaDomiciliarDAO.atualizar(visitaDomiciliar);
	}

	/**
	 * Metodo para realizar a busca do atendimento pelo identificador (ID) do
	 * mesmo. O id deve ser passado como parametro para que a busca no banco
	 * possa ser realizada, retornando o atendimento referente ao ID procurado.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public VisitaDomiciliar buscarPorId(Integer id) throws SisapException {
		return this.visitaDomiciliarDAO.buscarPorId(id);
	}

	public List<VisitaDomiciliar> getAll(String matriculaAluno, String nomeAluno)
			throws SisapException {
		try {
			return this.visitaDomiciliarDAO.getAll();
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
