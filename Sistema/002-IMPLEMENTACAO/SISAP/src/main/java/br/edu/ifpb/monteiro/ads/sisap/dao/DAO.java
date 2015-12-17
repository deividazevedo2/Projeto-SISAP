package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public abstract class DAO<T> implements Serializable {

	private static final long serialVersionUID = -315740615092329279L;

	@Inject
	private EntityManager entityManager;

	private Class<T> entity;

	public DAO(Class<T> entity) {
		this.entity = entity;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	}

	public void salvar(T entity) throws SisapException {
		entityManager.persist(entity);
	}

	public T atualizar(T entity) throws SisapException {
		entityManager.merge(entity);
		return entity;
	}

	public void remover(T entity) throws SisapException{
		entityManager.remove(entity);
	}

	public T consultarPorId(Long id) throws SisapException {
		return entityManager.find(this.entity, id);
	}

}
