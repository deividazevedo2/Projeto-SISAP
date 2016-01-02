package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;

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
		em.persist(pessoa);
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
		resultado = em.merge(pessoa);
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
		em.remove(em.merge(pessoa));
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
		resultado = em.find(Pessoa.class, matriculaSuap);
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
		resultado = em.find(Pessoa.class, id);
		return resultado;
	}

}
