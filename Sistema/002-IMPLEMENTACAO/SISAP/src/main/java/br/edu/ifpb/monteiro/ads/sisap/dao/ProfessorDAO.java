package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class ProfessorDAO extends DAO {

	private static final long serialVersionUID = 4651136765722356561L;

	/**
	 * Metodo para salvar uma entidade Professor no banco de dados.
	 * 
	 * @param professor
	 * @throws SisapException
	 */
	public void salvar(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		em.persist(professor);
	}

	/**
	 * Metodo para realizar a alteracao e atualizacao dos dados de uma entidade
	 * professor passada como parametro neste metodo.
	 * 
	 * @param professor
	 * @return
	 * @throws SisapException
	 */
	public Professor atualizar(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		return em.merge(professor);
	}

	/**
	 * Neste metodo pode-se remover o cadastro de uma entidade professor passada
	 * como parametro cujo possui cadastro no banco de dados do sistema SISAP.
	 * 
	 * @param professor
	 * @throws SisapException
	 */
	public void remover(Professor professor) throws SisapException {
		EntityManager em = getEntityManager();
		em.remove(em.merge(professor));
	}

	/**
	 * Este metodo realiza uma busca de uma determinada entidade professor que
	 * possui matricula correspondente a que esta sendo passada como parametro.
	 * O objeto buscado eh retornado para os devidos fins que sera utilizado.
	 * 
	 * @param matriculaSuap
	 * @return
	 * @throws SisapException
	 */
	public Professor buscarPorMatricula(String matriculaSuap)
			throws SisapException {
		EntityManager em = getEntityManager();
		return em.find(Professor.class, matriculaSuap);
	}

	/**
	 * Este metodo realiza uma busca da entidade professor atraves do
	 * identificados (ID) passado como parametro.
	 * 
	 * @param id
	 * @return
	 * @throws SisapException
	 */
	public Professor buscarPorId(Long id) throws SisapException {
		EntityManager em = getEntityManager();
		return em.find(Professor.class, id);
	}

}
