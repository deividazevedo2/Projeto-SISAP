package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.*;

import static org.junit.Assert.*;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class PedagogoDAOTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static PedagogoDAO pedagogoDAO;

	public PedagogoDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		pedagogoDAO = new PedagogoDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		pedagogoDAO.setEntityManager(em);

	}

	@Test(expected = Exception.class)
	public void testSalvarPedagogoNull() {
		Pedagogo pedagogo = new Pedagogo();

		//pedagogoDAO.salvar(pedagogo);

	}

}
