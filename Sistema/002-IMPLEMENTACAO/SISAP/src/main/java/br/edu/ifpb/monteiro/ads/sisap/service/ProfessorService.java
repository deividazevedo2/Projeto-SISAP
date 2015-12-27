package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.monteiro.ads.sisap.dao.ProfessorDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorDAO professorDAO;

	/**
	 * Metodo para salvar um novo prfessor, chamando a classe professorDAO onde
	 * a entidade em questao devera ser persistida no banco.
	 * 
	 * @param professor
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void salvar(Professor professor) throws SisapException {
		this.professorDAO.salvar(professor);

	}

	/**
	 * Este metodo atualiza um determinado professor que esta sendo passado como
	 * parametro. Sera chamado o professorDAO que fara a busca no banco e ira
	 * alterar os dados que foram modificados.
	 * 
	 * @param professor
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Professor atualizar(Professor professor) throws SisapException {
		return professorDAO.atualizar(professor);
	}

	/**
	 * Metodo para remover um professor do cadastro de usuarios no banco. Sera
	 * chamado o professorDAO que fara a busca deste registro e removera o
	 * cadastro do mesmo.
	 * 
	 * @param professor
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void remover(Professor professor) throws SisapException {
		this.professorDAO.remover(professor);

	}

	/**
	 * Metodo para realizar a busca do professor pelo identificador (ID) do
	 * mesmo. O id deve ser passado como parametro para que a busca no banco
	 * possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param idProfessor
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Professor buscarPorId(Long idProfessor) throws SisapException {
		return this.professorDAO.buscarPorId(idProfessor);
	}

	/**
	 * Metodo que realiza a busca do professor atraves da matricula passada como
	 * parametro no metodo.
	 * 
	 * @param matricula
	 *            A matricula recebida eh do tipo String, porem eh feito um cast
	 *            na chamada do metodo da classe professorDAO para que a busca
	 *            seja realizada, ja que o metodo no DAO deve receber a
	 *            matricula no tipo Long.
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Professor buscarPorMatricula(String matricula) throws SisapException {
		return ((ProfessorDAO) this.professorDAO).buscarPorMatricula(matricula);
	}

}
