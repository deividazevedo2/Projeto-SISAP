package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class PedagogoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4651136765722356561L;

	public void salvar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		em.persist(pedagogo);
	}

	public Pedagogo buscar(Long matriculaSuap) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		resultado = em.find(Pedagogo.class, matriculaSuap);
		return resultado;

	}

	public Pedagogo buscarPorMatricula(String matricula) throws SisapException {
		return new Pedagogo();
	}

	public Pedagogo alterar(Pedagogo pedagogo) throws SisapException {
		EntityManager em = getEntityManager();
		Pedagogo resultado = pedagogo;
		resultado = em.merge(pedagogo);
		return resultado;

	}

	public Pedagogo getById(Integer idPedagogo) throws SisapException {
		return new Pedagogo();
	}

	public List<Pedagogo> getAll() {
		EntityManager em = getEntityManager();
		List<Pedagogo> resultado = null;

		String jpql = "select a from Aluno_JS a where 1=1";

		return resultado;

	}

}
