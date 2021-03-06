package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.VisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe para realizar um CRUD relacionados a uma Visita Domiciliar. As
 * funcionalidades de salvar, alterar, buscar, e listar estão presentes aqui.
 * Não poderão ser removidos os dados após a confirmação de salvamento visto que
 * estas informações poderão vir a ser solicitadas em um momento futuro.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
public class VisitaDomiciliarDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417525816908228347L;

	private static final Log LOGGER = LogFactory
			.getLog(VisitaDomiciliarDAO.class);

	/**
	 * Realiza a persistencia da entidade VisitaDomiciliar passada como
	 * parametro no banco de dados.
	 * 
	 * @param visitaDomiciliar
	 * @return
	 * @throws SisapException
	 */
	public void salvar(VisitaDomiciliar visitaDomiciliar) {
		EntityManager em = getEntityManager();
		try {
			em.persist(visitaDomiciliar);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar a visita Domiciliar!", e);
		}
	}

	/**
	 * Atualiza a entidade VisitaDomiciliar passada como parametro no banco de
	 * dados.
	 * 
	 * @param visitaDomiciliar
	 * @return
	 * @throws SisapException
	 */
	public VisitaDomiciliar atualizar(VisitaDomiciliar visitaDomiciliar)
			throws SisapException {
		EntityManager em = getEntityManager();
		VisitaDomiciliar resultado = visitaDomiciliar;
		try {
			resultado = em.merge(visitaDomiciliar);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar o Visita Domiciliar!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca da entidade VisitaDomiciliar atraves do ID passado como
	 * parametro no metodo.
	 * 
	 * @param visitaDomiciliar
	 * @return
	 * @throws SisapException
	 */
	public VisitaDomiciliar buscarPorId(Integer id) throws SisapException {
		EntityManager em = getEntityManager();
		VisitaDomiciliar resultado = null;
		try {
			resultado = em.find(VisitaDomiciliar.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o Visita Domiciliar!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de uma Lista de VisitaDomiciliar.
	 * 
	 * @param
	 * @return
	 * @throws SisapException
	 */
	public List<VisitaDomiciliar> getAll() throws SisapException {
		EntityManager em = getEntityManager();
		List<VisitaDomiciliar> resultado = null;

		String jpql = "select visitadomiciliar from VisitaDomiciliar visitadomiciliar where 1=1";

		TypedQuery<VisitaDomiciliar> query = em.createQuery(jpql,
				VisitaDomiciliar.class);

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar as Visitas Domiciliares.",
					pe);
		}
		return resultado;
	}

}
