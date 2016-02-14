package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe para realizar o CRUD de Pedagogo (funcionalidades de salvar, buscar,
 * alterar, e listar). Remover não será uma das funcionalidades abordadas pelo
 * SISAP, visto que informações importantes podem ser procuradas em um tempo
 * futuro.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
public class PedagogoDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	private static final Log LOGGER = LogFactory.getLog(PedagogoDAO.class);

	/**
	 * Realiza a persistencia da entidade Pedagogo passada como parametro no
	 * banco de dados.
	 * 
	 * @param pedagogo
	 * @throws SisapException
	 */
	public void salvar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pedagogo);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar cadastro!", e);
		}
	}

	/**
	 * Atualiza o registro no banco de dados de uma determinada entidade
	 * Pedagogo passada como parametro.
	 * 
	 * @param pedagogo
	 * @return
	 * @throws SisapException
	 */
	public Pedagogo atualizar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = pedagogo;
		try {
			resultado = em.merge(pedagogo);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar cadastro!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca da entidade Pedagogo atraves do ID passado como parametro
	 * no metodo.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	public Pedagogo buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		try {
			resultado = em.find(Pedagogo.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o cadastro!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de uma determinada entidade PEdagogo atraves da matricula
	 * do pedagogo passada como parametro.
	 * 
	 * @param matriculaPedagogo
	 * @return
	 * @throws SisapException
	 */
	public Pedagogo buscarPorMatricula(String matriculaPedagogo)
			throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		try {
			TypedQuery<Pedagogo> query = em
					.createQuery(
							"select pedagogo from Pedagogo pedagogo where pedagogo.matricula like :matricula",
							Pedagogo.class);
			query.setParameter("matricula", "%" + matriculaPedagogo + "%");
			resultado = query.getSingleResult();
		} catch (PersistenceException e) {
			LOGGER.warn(
					"Ocorreu um problema ao buscar o cadastro pela matricula!",
					e);
		}

		return resultado;

	}

	/**
	 * Realiza a busca de uma determinada Lista de Alunos atraves da matricula e
	 * do nome passados como parâmentros
	 * 
	 * @param matricula
	 * @param nome
	 * @return List<Pedagogo>
	 * @throws SisapException
	 */
	public List<Pedagogo> getAll(String matricula, String nome)
			throws SisapException {
		EntityManager em = getEntityManager();
		List<Pedagogo> resultado = null;

		String jpql = "select pedagogo from Pedagogo pedagogo where 1=1";

		if (matricula != null && !matricula.isEmpty()) {
			jpql += " and pedagogo.matriculaSuap = :matricula";
		}

		if (nome != null && !nome.isEmpty()) {
			jpql += " and pedagogo.primeiroNome like :nome";
		}

		TypedQuery<Pedagogo> query = em.createQuery(jpql, Pedagogo.class);

		if (matricula != null && !matricula.isEmpty()) {
			query.setParameter("matricula", "%" + matricula + "%");
		}

		if (nome != null && !nome.isEmpty()) {
			query.setParameter("nome", "%" + nome + "%");
		}

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar os pedagogos com base no nome e/ou matricula.",
					pe);
		}
		return resultado;
	}

}
