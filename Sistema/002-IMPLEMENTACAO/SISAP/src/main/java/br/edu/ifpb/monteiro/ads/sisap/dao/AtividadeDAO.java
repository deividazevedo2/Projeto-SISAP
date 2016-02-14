package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe para realizar um CRUD básico de atividades no banco de dados.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
public class AtividadeDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417525816908228347L;

	private static final Log LOGGER = LogFactory.getLog(AtividadeDAO.class);

	/**
	 * Realiza a persistencia da entidade Atividade passada como parametro no
	 * banco de dados.
	 * 
	 * @param atividade
	 * @throws SisapException
	 */
	public void salvar(Atividade atividade) {
		EntityManager em = getEntityManager();
		try {
			em.persist(atividade);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar o atendimento!", e);
		}
	}

	/**
	 * Atualiza o registro no banco de dados de uma determinada entidade
	 * Atividade passada como parametro.
	 * 
	 * @param atendimento
	 * @return Atividade
	 * @throws SisapException
	 */
	public Atividade atualizar(Atividade atividade) throws SisapException {
		EntityManager em = getEntityManager();
		Atividade resultado = atividade;
		try {
			resultado = em.merge(atividade);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar o atendimento!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca da entidade Atividade atraves do ID passado como
	 * parametro no metodo.
	 * 
	 * @param id
	 * @return Atividade
	 * @throws SisapException
	 */
	public Atividade buscarPorId(Integer id) throws SisapException {
		EntityManager em = getEntityManager();
		Atividade resultado = null;
		try {
			resultado = em.find(Atividade.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o atendimento!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de uma determinada Lista de Atividades atraves da
	 * matricula e do nome passados como parâmentros
	 * 
	 * @param matricula
	 * @param nome
	 * @return
	 * @throws SisapException
	 */
	public List<Atividade> getAll(String matricula, String nome)
			throws SisapException {
		EntityManager em = getEntityManager();
		List<Atividade> resultado = null;

		String jpql = "select atividade from Atividade atividade where 1=1";

		if (matricula != null && !matricula.isEmpty()) {
			jpql += " and atividade.aluno.matricula = :matricula";
		}

		if (nome != null && !nome.isEmpty()) {
			jpql += " and atividade.aluno.nome like :nome";
		}

		TypedQuery<Atividade> query = em.createQuery(jpql, Atividade.class);

		if (matricula != null && !matricula.isEmpty()) {
			query.setParameter("matricula", "%" + matricula + "%");
		}

		if (nome != null && !nome.isEmpty()) {
			query.setParameter("nome", "%" + nome + "%");
		}

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			LOGGER.warn(
					"Ocorreu algum problema ao tentar recuperar as atividades registradas com base no nome e/ou matricula.",
					pe);
		}
		return resultado;
	}
}
