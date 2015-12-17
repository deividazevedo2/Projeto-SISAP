package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.interfaces.ServiceIF;

public class Service<T> implements Serializable, ServiceIF<T> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private Class<T> entity;

	public Service() {
	}

	public Class<T> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void salvar(T entity) throws SisapException {
		entityManager.persist(entity);
	}

	@Override
	public T atualizar(T entity) throws SisapException {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void remover(T entity) throws SisapException {
		entityManager.remove(entity);
	}

	@Override
	public T consultarPorId(Long id) throws SisapException {
		return entityManager.find(this.entity, id);
	}

}
