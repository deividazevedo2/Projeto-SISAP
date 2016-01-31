package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class AtendimentoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417525816908228347L;

	private static final Log LOGGER = LogFactory.getLog(AtendimentoDAO.class);

	public void Salvar(Atendimento atendimento) {
		EntityManager em = getEntityManager();
		try {
			em.persist(atendimento);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao salvar o atendimento!", e);
		}
	}

	public Atendimento atualizar(Atendimento atendimento) throws SisapException {
		EntityManager em = getEntityManager();
		Atendimento resultado = atendimento;
		try {
			resultado = em.merge(atendimento);
		} catch (PersistenceException e) {
			LOGGER.warn("Erro ao alterar o atendimento!", e);
		}
		return resultado;
	}

	public Atendimento buscarPorId(Integer id) throws SisapException {
		EntityManager em = getEntityManager();
		Atendimento resultado = null;
		try {
			resultado = em.find(Atendimento.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o atendimento!", e);
		}
		return resultado;
	}

	public List<Atendimento> getAll(String matricula, String nome)
			throws SisapException {
		EntityManager em = getEntityManager();
		List<Atendimento> resultado = null;

		String jpql = "select atendimento from Atendimento atendimento where 1=1";

		if (matricula != null && !matricula.isEmpty()) {
			jpql += " and atendimento.aluno.matricula = :matricula";
		}

		if (nome != null && !nome.isEmpty()) {
			jpql += " and atendimento.aluno.nome like :nome";
		}

		TypedQuery<Atendimento> query = em.createQuery(jpql, Atendimento.class);

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
					"Ocorreu algum problema ao tentar recuperar os atendimentos do aluno com base no nome e/ou matricula.",
					pe);
		}
		return resultado;
	}

}
