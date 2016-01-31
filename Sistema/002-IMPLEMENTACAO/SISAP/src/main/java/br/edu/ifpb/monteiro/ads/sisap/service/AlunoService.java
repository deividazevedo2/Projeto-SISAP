package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.edu.ifpb.monteiro.ads.sisap.dao.AlunoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class AlunoService implements Serializable {

	@Inject
	private transient AlunoDAO alunoDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694613964483092616L;

	/**
	 * Metodo para realizar a busca do Aluno pela matricula do mesmo. A
	 * matricula deve ser passada como parametro para que a busca no banco possa
	 * ser realizada, retornando o cadastro referente.
	 * 
	 * @param idAluno
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Aluno buscarPorMatricula(String matricula) throws SisapException {
		return this.alunoDAO.buscarPorMatricula(matricula);
	}

	/**
	 * Metodo para realizar a busca das notas do Aluno pela matricula do mesmo.
	 * A matricula deve ser passada como parametro para que a busca no banco
	 * possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public ArrayList<Float> buscarNotasDoAluno(Long matricula)
			throws SisapException {
		return this.alunoDAO.buscarNotaPorMatricula(matricula);
	}

	/**
	 * Metodo para realizar a busca das frequencias do Aluno pela matricula do
	 * mesmo. A matricula deve ser passada como parametro para que a busca no
	 * banco possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
//	@TransacionalCdi
//	public String buscarFrequenciaDoAluno(Long matricula) throws SisapException {
//		return this.alunoDAO.buscarFrequenciaDoAluno(matricula);
//	}

	@TransacionalCdi
	public Aluno buscarPorId(int id) throws SisapException {
		return this.alunoDAO.buscarPorId(id);
	}

	public List<Aluno> getAll(String matriculaAluno, String nomeAluno)
			throws SisapException {
		try {
			return this.alunoDAO.getAll(matriculaAluno, nomeAluno);
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
