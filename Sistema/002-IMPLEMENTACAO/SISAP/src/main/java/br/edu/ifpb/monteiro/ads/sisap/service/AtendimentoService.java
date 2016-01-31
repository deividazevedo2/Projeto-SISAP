package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.monteiro.ads.sisap.dao.AtendimentoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class AtendimentoService implements Serializable {

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private transient AtendimentoDAO atendimentoDAO;

	public AtendimentoDAO getAtendimentoDAO() {
		return atendimentoDAO;
	}

	public void setAtendimentoDAO(AtendimentoDAO atendimentoDAO) {
		this.atendimentoDAO = atendimentoDAO;
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
	public void salvar(Atendimento atendimento) throws SisapException {
		this.atendimentoDAO.salvar(atendimento);

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
	public Atendimento atualizar(Atendimento atendimento) throws SisapException {
		return atendimentoDAO.atualizar(atendimento);
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
	public Atendimento buscarPorId(Integer id) throws SisapException {
		return this.atendimentoDAO.buscarPorId(id);
	}

}
