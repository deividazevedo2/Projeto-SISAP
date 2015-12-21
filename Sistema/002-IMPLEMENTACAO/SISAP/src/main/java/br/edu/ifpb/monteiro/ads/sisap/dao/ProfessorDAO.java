package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class ProfessorDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	public void salvar(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(professor);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao salvar o cadastro!");
		}
	}

	public Professor atualizar(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		Professor resultado = professor;
		try {
			resultado = em.merge(professor);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao alterar o cadastro!");
		}
		return resultado;
	}

	public void remover(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			professor = em.merge(professor);
			em.remove(professor);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao deletar o cadastro!");
		}
	}

	public Professor buscarPorMatricula(String matriculaSuap)
			throws SisapException {
		EntityManager em = getEntityManager();
		Professor resultado = null;
		try {
			resultado = em.find(Professor.class, matriculaSuap);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}

	public Professor buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Professor resultado = null;
		try {
			resultado = em.find(Professor.class, id);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}

}
