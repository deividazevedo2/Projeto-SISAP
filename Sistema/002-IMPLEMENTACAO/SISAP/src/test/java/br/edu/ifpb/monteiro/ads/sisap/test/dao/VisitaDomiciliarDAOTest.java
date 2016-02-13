package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.VisitaDomiciliarDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.VisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class VisitaDomiciliarDAOTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static VisitaDomiciliarDAO domiciliarDAO;
	private static VisitaDomiciliar visitaDomiciliar;

	public VisitaDomiciliarDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		domiciliarDAO = new VisitaDomiciliarDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		domiciliarDAO.setEntityManager(em);

		visitaDomiciliar = new VisitaDomiciliar();
		visitaDomiciliar.setDataDeAgendamento("05/04/2016");
		visitaDomiciliar.setDataDeFinalizacao("06/04/2016");
		visitaDomiciliar.setDescricao("Descricao Visita");
		visitaDomiciliar.setMatriculaAluno("444444");
		visitaDomiciliar.setSituacao("Agendada");
		visitaDomiciliar.setMotivo("Motivo Visita");
		visitaDomiciliar.setAnalise("Analise");
		visitaDomiciliar.setNomeAluno("Joao");
		em.persist(visitaDomiciliar);

	}

	
	@Test
	public void buscarTodasVisitasDomiciliares() {
		try {
					
			List<VisitaDomiciliar> visita = domiciliarDAO.getAll();
			assertNotEquals(1000, visita.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}
	
	
}