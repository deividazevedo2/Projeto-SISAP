package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Classe responsável por realizar a busca das atividades do Pedagogo,
 * registradas até o momento no banco de dados. Ele poderá visualizar todas as
 * atividades realizadas não apenas por ele, mas por outro pedagogo que também
 * tenha realizado as operações de salvamento das diversas atividades
 * disponibilizadas pelo SISAP.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
public class DiarioDeAtividadesDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -150215743412562534L;

	private static final Log LOGGER = LogFactory
			.getLog(DiarioDeAtividadesDAO.class);

	public DiarioDeAtividadesDAO() {
	}

	/**
	 * Realiza a busca de todas as atividades registradas pelo pedagogo para que
	 * possa ser visualizada a lista de atividades do usuario.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public List<Atividade> getAll() throws SisapException {
		EntityManager em = getEntityManager();
		List<Atividade> resultado = null;

		String jpql = "select atividade from Atividade atividade where 1=1";

		TypedQuery<Atividade> query = em.createQuery(jpql, Atividade.class);

		try {
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			LOGGER.warn("Ocorreu um problema ao gerar o Relatorio!", pe);
		}
		return resultado;

	}

}
