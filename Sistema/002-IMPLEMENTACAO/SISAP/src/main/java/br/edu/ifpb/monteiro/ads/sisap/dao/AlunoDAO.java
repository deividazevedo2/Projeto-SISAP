package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe para realizar as operações pertinentes ao manipulamento de informações
 * acerca de um Aluno. Vale ressaltar que, nem todas as operações básicas de um
 * CRUD convencional estarão presentes aqui, tal qual salvar, alterar, remover,
 * visto que as informações (dados) devem vir de um banco de dados externo onde
 * o SISAP poderá apenas realizar operações de visualização.
 * 
 * @author Indy, Deivid, Widancássio
 *
 */
public class AlunoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -601004838687928376L;

	private static final Log LOGGER = LogFactory.getLog(AlunoDAO.class);

	/**
	 * Realiza a busca da entidade Aluno atraves do ID passado como parametro no
	 * metodo.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	public Aluno buscarPorId(int id) throws SisapException {
		EntityManager em = getEntityManager();
		Aluno resultado = null;
		try {
			resultado = em.find(Aluno.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o Aluno!", e);
		}
		return resultado;
	}

	/**
	 * Realiza a busca de um determinado Aluno atraves da matricula passados
	 * como parâmentros
	 * 
	 * @param matricula
	 * @return Aluno
	 * @throws SisapException
	 */
	public Aluno buscarPorMatricula(String matricula) throws SisapException {
		EntityManager em = getEntityManager();
		Aluno resultado = null;
		if (matricula == null) {
			matricula = "";
		}
		try {
			TypedQuery<Aluno> query = em
					.createQuery(
							"select aluno from Aluno aluno where aluno.matricula like :matricula",
							Aluno.class);
			query.setParameter("matricula", "%" + matricula + "%");
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
	 * do nome passados como par�mentros
	 * 
	 * @param matricula
	 * @param nome
	 * @return List<Aluno>
	 * @throws SisapException
	 */
	public List<Aluno> getAll(String matricula, String nome)
			throws SisapException {
		EntityManager em = getEntityManager();
		List<Aluno> resultado = null;

		String jpql = "select aluno from Aluno aluno where 1=1";

		if (matricula != null && !matricula.isEmpty()) {
			jpql += " and aluno.matricula = :matricula";
		}

		if (nome != null && !nome.isEmpty()) {
			jpql += " and aluno.nome like :nome";
		}

		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);

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
					"Ocorreu algum problema ao tentar recuperar os alunos com base no nome e/ou matricula.",
					pe);
		}
		return resultado;
	}

}
