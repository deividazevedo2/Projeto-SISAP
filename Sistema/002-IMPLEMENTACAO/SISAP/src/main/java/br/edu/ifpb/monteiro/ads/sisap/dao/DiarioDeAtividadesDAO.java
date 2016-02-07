package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
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

	public void gerarRelatorio() throws SisapException {

		try {
			JasperReport report = JasperCompileManager
					.compileReport("relatorios/RelatorioClientes.jrxml");

			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(atividades));

			// exportacao do relatorio para o formato PDF
			JasperExportManager.exportReportToPdfFile(print,
					"relatorios/RelatorioAtividades.pdf");

		} catch (JRException e) {
			LOGGER.warn("Ocorreu um problema ao gerar o Relatorio!", e);
		}

	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

}
