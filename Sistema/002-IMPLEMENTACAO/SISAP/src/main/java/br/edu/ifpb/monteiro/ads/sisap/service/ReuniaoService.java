package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.ReuniaoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class ReuniaoService implements Serializable {

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private ReuniaoDAO reuniaoDAO;

	public ReuniaoDAO getReuniaoDAO() {
		return reuniaoDAO;
	}

	public void setReuniaoDAO(ReuniaoDAO reuniaoDAO) {
		this.reuniaoDAO = reuniaoDAO;
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
	public void salvar(Reuniao reuniao) throws SisapException {
		this.reuniaoDAO.salvar(reuniao);

	}

	/**
	 * Este metodo atualiza um determinado atendimento que esta sendo passado
	 * como parametro. Sera chamado o atendimentoDAO que fara a busca no banco e
	 * ira alterar os dados que foram modificados na ficha do atendimento.
	 * 
	 * @param reuniao
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Reuniao atualizar(Reuniao reuniao) throws SisapException {
		return reuniaoDAO.atualizar(reuniao);
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
	public Reuniao buscarPorId(Integer id) throws SisapException {
		return this.reuniaoDAO.buscarPorId(id);
	}

	public List<Reuniao> getAll() throws SisapException {
		try {
			return this.reuniaoDAO.getAll();
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
