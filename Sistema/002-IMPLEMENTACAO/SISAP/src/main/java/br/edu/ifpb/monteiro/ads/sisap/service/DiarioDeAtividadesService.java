package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.DiarioDeAtividadesDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class DiarioDeAtividadesService implements Serializable {

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private DiarioDeAtividadesDAO diarioDeAtividadesDAO;

	public DiarioDeAtividadesDAO getDiarioDeAtividadesDAO() {
		return diarioDeAtividadesDAO;
	}

	public void setDiarioDeAtividadesDAO(
			DiarioDeAtividadesDAO diarioDeAtividadesDAO) {
		this.diarioDeAtividadesDAO = diarioDeAtividadesDAO;
	}

	public List<Atividade> getAll() throws SisapException {
		try {
			return this.diarioDeAtividadesDAO.getAll();
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

	public void gerarRelatorio() throws SisapException {
		try {
			this.diarioDeAtividadesDAO.gerarRelatorio();
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
