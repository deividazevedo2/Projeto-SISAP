package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.monteiro.ads.sisap.dao.BoletimDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Boletim;
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
public class BoletimService implements Serializable {

	@Inject
	private transient BoletimDAO bimestreDAO;

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
	public List<Boletim> buscarNotasDoAluno(String matricula)
			throws SisapException {
		return this.bimestreDAO.buscarBoletimDoAluno(matricula);
	}

}
