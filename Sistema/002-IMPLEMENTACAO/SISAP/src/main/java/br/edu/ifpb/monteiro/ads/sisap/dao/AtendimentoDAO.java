package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
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

	public Atendimento buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Atendimento resultado = null;
		try {
			resultado = em.find(Atendimento.class, id);
		} catch (PersistenceException e) {
			LOGGER.warn("Ocorreu um problema ao buscar o atendimento!", e);
		}
		return resultado;
	}

	public Atendimento buscarPorAluno(String matriculaAluno)
			throws SisapException {
		EntityManager em = getEntityManager();
		Atendimento resultado = null;
		try {
			TypedQuery<Atendimento> query = em
					.createQuery(
							"select atendimento from Atendimento atendimento where atendimento.aluno like :aluno_fk",
							Atendimento.class);
			query.setParameter("aluno_fk", "%" + matriculaAluno + "%");
			resultado = query.getSingleResult();
		} catch (PersistenceException e) {
			LOGGER.warn(
					"Ocorreu um problema ao buscar o cadastro pela matricula!",
					e);
		}

		return resultado;

	}

}
