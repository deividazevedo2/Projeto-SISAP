package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Nota;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class NotaDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704130501904279068L;

	private static final Log LOGGER = LogFactory.getLog(AtendimentoDAO.class);

	/**
	 * Realiza a busca de uma determinada Lista de notas atraves da matricula do
	 * aluno
	 * 
	 * @param idAluno
	 * @param nome
	 * @return
	 * @throws SisapException
	 */
	public List<Nota> buscarNotasDoAluno(Integer idAluno) throws SisapException {
		EntityManager em = getEntityManager();
		List<Nota> resultado = null;

		String jpql = "select nota from Nota nota where 1=1";

		if (idAluno != null && (idAluno > 0)) {
			jpql += " and nota.matricula = :matricula";
		}

		TypedQuery<Nota> query = em.createQuery(jpql, Nota.class);

		if (idAluno != null && (idAluno > 0)) {
			query.setParameter("matricula", "%" + idAluno + "%");
		}

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			LOGGER.warn("Ocorreu um problema ao buscar as notas do aluno!", pe);
		}
		return resultado;
	}

}
