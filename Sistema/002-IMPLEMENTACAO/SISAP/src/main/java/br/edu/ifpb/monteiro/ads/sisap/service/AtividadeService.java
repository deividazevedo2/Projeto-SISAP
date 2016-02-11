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
	 * Metodo para salvar uma nova atividade, chamando a classe atividadeDAO
	 * onde o registro devera ser salvo no banco de dados da aplicação.
	 * 
	 * @param atividade
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void salvar(Atividade atividade) throws SisapException {
		this.atividadeDAO.salvar(atividade);

	}

	/**
	 * Este metodo atualiza uma determinada atividade que esta sendo passada
	 * como parametro. Sera chamada a AtividadeDAO que fara a busca no banco e
	 * ira alterar os dados que forem modificados.
	 * 
	 * @param atividade
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Atividade atualizar(Atividade atividade) throws SisapException {
		return atividadeDAO.atualizar(atividade);
	}

	/**
	 * Metodo para realizar a busca de uma Atividade pelo identificador (ID) da
	 * mesma. O id deve ser passado como parametro para que a busca no banco
	 * possa ser realizada, retornando a Atividade referente ao ID procurado.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Atividade buscarPorId(Integer id) throws SisapException {
		return this.atividadeDAO.buscarPorId(id);
	}

	/**
	 * Método para realizar a busca de todas as atividades registradas no banco
	 * de dados da aplicação. Retorna uma lista de atividades de acordo com os
	 * parâmetros passados e/ou caso estes sejam nulos, retorna uma lista com
	 * todas as atividades.
	 * 
	 * @param matriculaAluno
	 * @param nomeAluno
	 * @return
	 * @throws SisapException
	 */
	public List<Atividade> getAll(String matriculaAluno, String nomeAluno)
			throws SisapException {
		try {
			return this.atividadeDAO.getAll(matriculaAluno, nomeAluno);
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
