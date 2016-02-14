package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Outras classes DAOs devem realizar um extends desta para que possam capturar
 * o getEntityManager e realizar as suas operações corretamente.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
public abstract class DAO implements Serializable {

	private static final long serialVersionUID = -315740615092329279L;

	@Inject
	private transient EntityManager entityManager;

	/**
	 * Capturando o getEntityManager para que outras classes, ao implementarem,
	 * possam realizar a chamada deste GET e conseguir fazer suas operações
	 * corretamente.
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
