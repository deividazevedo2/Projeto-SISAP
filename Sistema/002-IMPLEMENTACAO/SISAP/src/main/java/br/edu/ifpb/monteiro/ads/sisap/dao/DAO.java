package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class DAO implements Serializable {

	private static final long serialVersionUID = -315740615092329279L;

	@Inject
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
