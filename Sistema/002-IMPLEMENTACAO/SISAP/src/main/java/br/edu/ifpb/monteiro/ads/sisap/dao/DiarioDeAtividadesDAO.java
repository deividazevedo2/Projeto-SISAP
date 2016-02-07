package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class DiarioDeAtividadesDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -150215743412562534L;

	private static final Log LOGGER = LogFactory
			.getLog(DiarioDeAtividadesDAO.class);

	private ArrayList<Atividade> atividades;

	public DiarioDeAtividadesDAO() {
		atividades = new ArrayList<Atividade>();
	}

	/**
	 * Realiza a busca de todas as atividades registradas pelo pedagogo para que
	 * possa ser visualizada a lista de atividades do usuario.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public List<Atividade> getAll() throws SisapException {
		// List<Atendimento> atendimentos = buscaAtendimentos();
		// for (Atendimento atendimento : atendimentos) {
		// atividades.add(atendimento);
		// }
		//
		// List<Reuniao> reunioes = buscaReunioes();
		// for (Reuniao reuniao : reunioes) {
		// atividades.add(reuniao);
		// }
		//
		// List<VisitaDomiciliar> visitas = buscaVisitas();
		// for (VisitaDomiciliar visita : visitas) {
		// atividades.add(visita);
		// }
		//
		// return atividades;
		EntityManager em = getEntityManager();
		List<Atividade> resultado = null;

		String jpql = "select atividade from Atividade atividade where 1=1";

		TypedQuery<Atividade> query = em.createQuery(jpql, Atividade.class);

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new SisapException(
					"Ocorreu algum problema ao tentar recuperar as reunioess.",
					pe);
		}
		return resultado;

	}

	/**
	 * Realiza a busca das atividades do tipo Atendimento.
	 * 
	 * @return
	 * @throws SisapException
	 */
	// public List<Atendimento> buscaAtendimentos() throws SisapException {
	// EntityManager em = getEntityManager();
	// List<Atendimento> atendimentos = null;
	//
	// String jpql =
	// "select atendimento from Atendimento atendimento where 1=1";
	//
	// TypedQuery<Atendimento> query = em.createQuery(jpql, Atendimento.class);
	//
	// try {
	// atendimentos = query.getResultList();
	// } catch (PersistenceException e) {
	// LOGGER.warn(
	// "Ocorreu um problema ao buscar as atividades de Atendimento!",
	// e);
	// }
	// return atendimentos;
	// }

	/**
	 * Realiza a busca das atividades do tipo Reuniao.
	 * 
	 * @return
	 * @throws SisapException
	 */
	// public List<Reuniao> buscaReunioes() throws SisapException {
	// EntityManager em = getEntityManager();
	// List<Reuniao> reunioes = null;
	//
	// String jpql = "select reuniao from Reuniao reuniao where 1=1";
	//
	// TypedQuery<Reuniao> query = em.createQuery(jpql, Reuniao.class);
	//
	// try {
	// reunioes = query.getResultList();
	// } catch (PersistenceException e) {
	// LOGGER.warn(
	// "Ocorreu um problema ao buscar as atividades de Reuniao!",
	// e);
	// }
	// return reunioes;
	// }

	/**
	 * Realiza a busca das atividades do tipo Visita Domiciliar.
	 * 
	 * @return
	 * @throws SisapException
	 */
	// public List<VisitaDomiciliar> buscaVisitas() throws SisapException {
	// EntityManager em = getEntityManager();
	// List<VisitaDomiciliar> visitas = null;
	//
	// String jpql =
	// "select visita_domiciliar from Visita_Domiciliar visita_domiciliar where 1=1";
	//
	// TypedQuery<VisitaDomiciliar> query = em.createQuery(jpql,
	// VisitaDomiciliar.class);
	//
	// try {
	// visitas = query.getResultList();
	// } catch (PersistenceException e) {
	// LOGGER.warn(
	// "Ocorreu um problema ao buscar as atividades de Visita Domiciliar!",
	// e);
	// }
	// return visitas;
	// }

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

}
