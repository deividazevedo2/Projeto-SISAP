package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.monteiro.ads.sisap.dao.NotaDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Nota;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class NotaService implements Serializable {

	@Inject
	private transient NotaDAO notaDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694613964483092616L;

	@TransacionalCdi
	public List<Nota> buscarNotasDoAluno(Integer idAluno) throws SisapException {
		return this.notaDAO.buscarNotasDoAluno(idAluno);
	}

}
