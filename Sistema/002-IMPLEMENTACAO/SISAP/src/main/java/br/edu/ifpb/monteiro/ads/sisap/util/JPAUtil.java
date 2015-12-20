package br.edu.ifpb.monteiro.ads.sisap.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory criarEMF() {
		return Persistence.createEntityManagerFactory("SISAP");
	}

	@Produces
	@RequestScoped
	public EntityManager criarEM(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void fecharEM(@Disposes EntityManager em) {
		em.close();
	}

}
