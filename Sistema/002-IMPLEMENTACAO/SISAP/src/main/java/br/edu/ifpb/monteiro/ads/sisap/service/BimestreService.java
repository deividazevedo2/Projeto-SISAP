package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.monteiro.ads.sisap.dao.BimestreDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Bimestre;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

/**
 * Classe que faz a chamada de um BEAN para um DAO em uma mesma conversação.
 * Aqui consta apenas o método de buscar notas do aluno, pois esta é a única e
 * principal meta do SISAP: realizar uma busca e uma análise destas notas.
 * 
 * @author Deivid Azevedo
 *
 */
public class BimestreService implements Serializable {

	@Inject
	private transient BimestreDAO bimestreDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694613964483092616L;

	/**
	 * Chamada do método no DAO de buscar notas do aluno com base na matricula
	 * passada como parâmetro aqui.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public List<Bimestre> buscarNotasDoAluno(String matricula)
			throws SisapException {
		return this.bimestreDAO.buscarNotasDoAluno(matricula);
	}

}
