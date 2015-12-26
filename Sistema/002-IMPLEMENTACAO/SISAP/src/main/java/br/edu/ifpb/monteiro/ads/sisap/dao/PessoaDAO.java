package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pessoa;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PessoaDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	/**
	 * Metodo para salvar uma entidade Pessoa no banco de dados do sistema.
	 * 
	 * @param pessoa
	 * @throws SisapException
	 */
	public void salvar(Pessoa pessoa) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pessoa);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao salvar o cadastro!");
		}
	}

	/**
	 * Metodo que realiza a atualizacao dos dados da entidade pessoa passada
	 * como parametro para ser persistida no banco de dados do sistema.
	 * 
	 * @param pessoa
	 * @return
	 * @throws SisapException
	 */
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

	/**
	 * Metodo para realizar a exclusao da pessoa no banco de dados do sistema.
	 * 
	 * @param pessoa
	 * @throws SisapException
	 */
	public void remover(Pessoa pessoa) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			pessoa = em.merge(pessoa);
			em.remove(pessoa);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao deletar o cadastro!");
		}
	}

	/**
	 * Este metodo busca um cadastro de uma entidade Pessoa no banco atraves da
	 * matricula passada como parametro.
	 * 
	 * @param matriculaSuap
	 * @return
	 * @throws SisapException
	 */
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

	/**
	 * Este metodo realiza a busca de uma determinada entidade Pessoa atraves do
	 * ID passado como parametro.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
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
