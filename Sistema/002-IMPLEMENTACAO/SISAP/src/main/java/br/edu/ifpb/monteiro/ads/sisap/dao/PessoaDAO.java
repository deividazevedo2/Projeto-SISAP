package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pessoa;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PessoaDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	public void salvar(Pessoa pessoa) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pessoa);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao salvar o cadastro!");
		}
	}

	public Pessoa atualizar(Pessoa pessoa) throws SisapException {
		EntityManager em = getEntityManager();
		Pessoa resultado = pessoa;
		try {
			resultado = em.merge(pessoa);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao alterar o cadastro!");
		}
		return resultado;
	}

	public void remover(Pessoa pessoa) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			pessoa = em.merge(pessoa);
			em.remove(pessoa);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao deletar o cadastro!");
		}
	}

	public Pessoa buscarPorMatricula(String matriculaSuap)
			throws SisapException {
		EntityManager em = getEntityManager();
		Pessoa resultado = null;
		try {
			resultado = em.find(Pessoa.class, matriculaSuap);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}

	public Pessoa buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		Pessoa resultado = null;
		try {
			resultado = em.find(Pessoa.class, id);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}

}
