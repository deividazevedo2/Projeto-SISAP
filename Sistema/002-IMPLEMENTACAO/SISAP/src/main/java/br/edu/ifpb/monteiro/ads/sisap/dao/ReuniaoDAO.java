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

	public void salvar(Reuniao reuniao) {
		EntityManager em = getEntityManager();
		try {
			em.persist(reuniao);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar a reunião!", e);
		}
	}

	public Reuniao atualizar(Reuniao reuniao) throws SisapException {
		EntityManager em = getEntityManager();
		Reuniao resultado = reuniao;
		try {
			resultado = em.merge(reuniao);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar o atendimento!", e);
		}
		return resultado;
	}

	public Reuniao buscarPorId(Integer id) throws SisapException {
		EntityManager em = getEntityManager();
		Reuniao resultado = null;
		try {
			resultado = em.find(Reuniao.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o atendimento!", e);
		}
		return resultado;
	}

	public List<Reuniao> getAll() throws SisapException {
		EntityManager em = getEntityManager();
		List<Reuniao> resultado = null;

		String jpql = "select reuniao from Reuniao reuniao where 1=1";

		TypedQuery<Reuniao> query = em.createQuery(jpql, Reuniao.class);

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar as reuniões.",
					pe);
		}
		return resultado;
	}

}
