package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class ReuniaoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417525816908228347L;

	private static final Log LOGGER = LogFactory.getLog(ReuniaoDAO.class);

	/**
	 * Realiza a persistencia da entidade Reuniao passada como parametro no
	 * banco de dados.
	 * 
	 * @param reuniao
	 * @throws SisapException
	 */
	public void salvar(Reuniao reuniao) {
		EntityManager em = getEntityManager();
		try {
			em.persist(reuniao);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar a reuniao!", e);
		}
	}

	/**
	 * Atualiza o registro no banco de dados de uma determinada entidade
	 * Reuniao passada como parametro.
	 * 
	 * @param reuniao
	 * @return
	 * @throws SisapException
	 */
	public Reuniao atualizar(Reuniao reuniao) throws SisapException {
		EntityManager em = getEntityManager();
		Reuniao resultado = reuniao;
		try {
			resultado = em.merge(reuniao);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar o reuniao!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca da entidade Reuniao atraves do ID passado como parametro
	 * no metodo.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	public Reuniao buscarPorId(Integer id) throws SisapException {
		EntityManager em = getEntityManager();
		Reuniao resultado = null;
		try {
			resultado = em.find(Reuniao.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o reuniao!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de uma determinada Lista de Reuniões 
	 * 
	 * @param 
	 * @return
	 * @throws SisapException
	 */
	public List<Reuniao> getAll() throws SisapException {
		EntityManager em = getEntityManager();
		List<Reuniao> resultado = null;

		String jpql = "select reuniao from Reuniao reuniao where 1=1";

		TypedQuery<Reuniao> query = em.createQuery(jpql, Reuniao.class);

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar as reunioess.",
					pe);
		}
		return resultado;
	}

}
