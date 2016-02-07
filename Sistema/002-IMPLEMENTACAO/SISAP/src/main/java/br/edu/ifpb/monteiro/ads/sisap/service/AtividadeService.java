package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.AtividadeDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class AtividadeService implements Serializable {

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private AtividadeDAO atividadeDAO;

	public AtividadeDAO getAtividadeDAO() {
		return atividadeDAO;
	}

	public void setAtividadeDAO(AtividadeDAO atividadeDAO) {
		this.atividadeDAO = atividadeDAO;
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
	public void salvar(Atividade atividade) throws SisapException {
		this.atividadeDAO.salvar(atividade);

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
	public Atividade atualizar(Atividade atividade) throws SisapException {
		return atividadeDAO.atualizar(atividade);
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
	public Atividade buscarPorId(Integer id) throws SisapException {
		return this.atividadeDAO.buscarPorId(id);
	}

	public List<Atividade> getAll(String matriculaAluno, String nomeAluno)
			throws SisapException {
		try {
			return this.atividadeDAO.getAll(matriculaAluno, nomeAluno);
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
