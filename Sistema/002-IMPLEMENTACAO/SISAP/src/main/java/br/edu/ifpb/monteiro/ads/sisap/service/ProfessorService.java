package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.ProfessorDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;
import br.edu.ifpb.monteiro.ads.sisap.validator.Validador;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorDAO professorDAO;
	private Validador validador;

	@TransacionalCdi
	public void salvar(Professor professor) throws SisapException {
		try {
			validador.ValidarCamposProfessor(professor);
			this.professorDAO.salvar(professor);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@TransacionalCdi
	public Professor atualizar(Professor professor) throws SisapException {
		try {
			validador.ValidarCamposProfessor(professor);
			return professorDAO.atualizar(professor);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}
	}

	@TransacionalCdi
	public void remover(Professor professor) throws SisapException {
		try {
			this.professorDAO.remover(professor);
		} catch (SisapException exception) {
			throw new SisapException(exception.getMessage());
		}

	}

	@TransacionalCdi
	public Professor buscarPorId(Long idProfessor) throws SisapException {
		try {
			return this.professorDAO.buscarPorId(idProfessor);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}
	}

	@TransacionalCdi
	public Professor buscarPorMatricula(String matricula) throws SisapException {
		try {
			return ((ProfessorDAO) this.professorDAO)
					.buscarPorMatricula(matricula);
		} catch (PersistenceException exception) {
			throw new SisapException(exception.getMessage(), exception);
		}

	}

}
