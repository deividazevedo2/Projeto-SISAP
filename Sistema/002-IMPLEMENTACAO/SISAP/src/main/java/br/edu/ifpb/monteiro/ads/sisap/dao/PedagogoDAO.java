package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PedagogoDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	public void salvar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao salvar o cadastro!");
		}
	}

	public Pedagogo atualizar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = pedagogo;
		try {
			resultado = em.merge(pedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao alterar o cadastro!");
		}
		return resultado;
	}

	public void remover(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			pedagogo = em.merge(pedagogo);
			em.remove(pedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao deletar o cadastro!");
		}
	}

	public Pedagogo buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		try {
			resultado = em.find(Pedagogo.class, id);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}

	public Pedagogo buscarPorMatricula(Long matriculaPedagogo)
			throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		if (matriculaPedagogo == null) {
			matriculaPedagogo = Long.valueOf("");
		}
		try {
			TypedQuery<Pedagogo> query = em
					.createQuery(
							"select pedagogo from Pedagogo pedagogo where pedagogo.matriculaSuap like :matricula",
							Pedagogo.class);
			query.setParameter("matricula", "%" + matriculaPedagogo + "%");
			resultado = query.getSingleResult();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Erro ao recuperar o pedagogo pela matricula.", pe);
		}

		return resultado;

	}

}
