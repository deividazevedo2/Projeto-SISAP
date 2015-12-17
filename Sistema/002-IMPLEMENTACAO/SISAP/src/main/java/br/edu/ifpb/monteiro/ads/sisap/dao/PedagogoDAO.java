package br.edu.ifpb.monteiro.ads.sisap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PedagogoDAO extends DAO<Pedagogo> {

	public PedagogoDAO(Class<Pedagogo> entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4651136765722356561L;

	@Override
	public void salvar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao salvar o cadastro!");
		}
	}

	@Override
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

	@Override
	public void remover(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		try {
			pedagogo = em.merge(pedagogo);
			em.remove(pedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException("Erro ao deletar o cadastro!");
		}
	}

	
	public Pedagogo buscarPorMatricula(String matriculaSuap)
			throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		try {
			resultado = em.find(Pedagogo.class, matriculaSuap);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;
	}
	
	@Override
	public Pedagogo buscaPorId(Long idPedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		try {
			resultado = em.find(Pedagogo.class, idPedagogo);
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu um problema ao buscar o cadastro!");
		}
		return resultado;

	}

}
