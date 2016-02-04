package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

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
	 * Realiza a busca de uma determinada entidade Aluno atraves da matricula
	 * do pedagogo passada como parametro.
	 * 
	 * @param matriculaAluno
	 * @return
	 * @throws SisapException
	 */
	public ArrayList<Float> buscarNotaPorMatricula(Long matriculaAluno)
			throws SisapException {
		ArrayList<Float> notas = new ArrayList<>();
		EntityManager em = getEntityManager();
		Float resultado = null;
		if (matriculaAluno == null) {
			matriculaAluno = Long.valueOf("");
		}
		try {
			TypedQuery<Pedagogo> query = em
					.createQuery(
							"select nota from TB_NOTA_DE_AVALIACAO where notaDaAvaliacao.aluno.matricula like :matriculaAluno",
							Pedagogo.class);
			query.setParameter("matricula", "%" + matriculaAluno + "%");
			notas.add(resultado);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar as notas!", e);
		}

		return notas;

	}
	
	/**
	 * Realiza a busca de um determinado Aluno atraves da matricula
	 *  passados como parâmentros 
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
	 * Realiza a busca de uma determinada Lista de Alunos atraves da matricula
	 *  e do nome passados como parâmentros 
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
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar os alunos com base no nome e/ou matricula.",
					pe);
		}
		return resultado;
	}

}
