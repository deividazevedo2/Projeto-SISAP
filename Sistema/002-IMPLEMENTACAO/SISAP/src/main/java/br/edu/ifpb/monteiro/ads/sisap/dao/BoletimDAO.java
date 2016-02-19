package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Boletim;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe para realizar a operação de busca das notas bimestrais de um
 * determinado aluno. Nesta classe conterá apenas o método de buscar notas de um
 * aluno, pois as operações básicas de um CRUD (salvar, alterar, excluir) não
 * poderão ser realizadas pelo SISAP, visto que estes dados (supõe-se que) vêm
 * de uma base externa (sistema acadêmico de alimentação de notas e frequências
 * de alunos).
 * 
 * @author Deivid Azevedo
 *
 */
public class BoletimDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704130501904279068L;

	private static final Log LOGGER = LogFactory.getLog(AtendimentoDAO.class);

	/**
	 * Cada aluno deverá ter uma lista de notas de bimestre em seu cadastro.
	 * Isso fará com que a equipe pedagógica possa acompanhar o rendimento
	 * acadêmico de cada aluno. A busca destas notas é feita a partir da
	 * matricula do aluno selecionado na tela de listagem dos mesmos.
	 * 
	 * @param matricula
	 * @return
	 * @throws SisapException
	 */
	public List<Boletim> buscarBoletimDoAluno(String matricula)
			throws SisapException {
		EntityManager em = getEntityManager();
		List<Boletim> resultado = null;

		String jpql = "select boletim from Boletim boletim where 1=1";

		if (matricula != null && !matricula.isEmpty()) {
			jpql += " and boletim.matricula like :matricula";
		}

		TypedQuery<Boletim> query = em.createQuery(jpql, Boletim.class);

		if (matricula != null && !matricula.isEmpty()) {
			query.setParameter("matricula", "%" + matricula + "%");
		}

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			LOGGER.warn("Ocorreu um problema ao buscar as notas do aluno!", pe);
		}
		return resultado;
	}

}
