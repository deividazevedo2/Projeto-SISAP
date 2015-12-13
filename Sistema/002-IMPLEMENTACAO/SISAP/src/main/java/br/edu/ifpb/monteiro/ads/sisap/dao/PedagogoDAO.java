package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class PedagogoDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4651136765722356561L;

	public void salvar(Pedagogo pedagogo) {
		EntityManager em = getEntityManager();
		em.persist(pedagogo);
	}

	public Pedagogo buscar(Integer matriculaSuap) {
		EntityManager em = getEntityManager();
		Pedagogo resultado = null;
		resultado = em.find(Pedagogo.class, matriculaSuap);
		return resultado;

	}

	public Pedagogo alterar(Pedagogo pedagogo) {
		EntityManager em = getEntityManager();
		Pedagogo resultado = pedagogo;
		resultado = em.merge(pedagogo);
		return resultado;

	}

	public List<Pedagogo> getAll() {
		EntityManager em = getEntityManager();
		List<Pedagogo> resultado = null;

		String jpql = "select a from Aluno_JS a where 1=1";

		return resultado;

	}

}
