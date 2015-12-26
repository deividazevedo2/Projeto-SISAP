package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PedagogoDAOTest {

	private static final String Null = null;
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static PedagogoDAO pedagogoDAO;
	private static Pedagogo pedagogo;

	public PedagogoDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		pedagogoDAO = new PedagogoDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		pedagogoDAO.setEntityManager(em);

		pedagogo = new Pedagogo();
		Endereco endereco = new Endereco();
		endereco.setBairro("Prado");
		endereco.setCep("55200-000");
		endereco.setCidade("Pesqueira");
		endereco.setNumero(11);
		endereco.setRua("Rua Santa Agueda");
		endereco.setUf("PE");

		Contato contato = new Contato();
		contato.setEmail("cassio@gmail.com");
		contato.setCelular("1234567890");

		pedagogo.setContato(contato);
		pedagogo.setMatriculaSuap("65050265265208");
		pedagogo.setSexo("masculino");
		pedagogo.setPrimeiroNome("Widancassio");
		pedagogo.setSegundoNome("Galindo");
		pedagogo.setCpf("000020000113");
		pedagogo.setEndereco(endereco);
		pedagogo.setSenha("31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b");

	}

	@Test(expected = PersistenceException.class)
	public void testSalvarPedagogoNull() {
		Pedagogo p1 = new Pedagogo();
		em.persist(p1);
		assertNull(em);

	}

	@Test(expected = PersistenceException.class)
	public void testSalvarPedagogoPrimeiroNomeVazio() {
		pedagogo.setPrimeiroNome(" ");
		em.persist(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoPrimeiroNomeComNull() {
		pedagogo.setPrimeiroNome(Null);
		em.persist(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testSalvarPedagogoSegundoNomeVazio() {
		pedagogo.setSegundoNome(" ");
		em.persist(pedagogo);

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoRGVazio() {
		pedagogo.setRg(" ");
		em.persist(pedagogo);

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoRGNull() {
		pedagogo.setRg(Null);
		em.persist(pedagogo);

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoCPFVazio() {
		pedagogo.setCpf(" ");
		em.persist(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoCPFNull() {
		pedagogo.setCpf(Null);
		em.persist(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.persist(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.persist(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testSalvarPedagogoComSenhaNull() {
		pedagogo.setSenha(Null);
		em.persist(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testSalvarPedagogoComSenhaVazia() {
		pedagogo.setSenha(" ");
		em.persist(pedagogo);
	}

	// ===================Parte de Atualizar ====================

	@Test(expected = PersistenceException.class)
	public void testAtualizarMatriculaParaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.merge(pedagogo);

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarMatriculaParaVazio() {
		pedagogo.setMatriculaSuap(" ");
		em.merge(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testAtualizarNomeParaNull() {
		pedagogo.setPrimeiroNome(Null);
		em.merge(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testAtualizarNomeParaVazio() {
		pedagogo.setSegundoNome(" ");
		em.merge(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testAtualizarSenhaParaNull() {
		pedagogo.setSenha(Null);
		em.merge(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testAtualizarSenhaParaVazio() {
		pedagogo.setSenha(" ");
		em.merge(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testAtualizarCpfParaNull() {
		pedagogo.setCpf(Null);
		em.merge(pedagogo);
	}

	@Test(expected = PersistenceException.class)
	public void testAtualizarCpfParaVazio() {
		pedagogo.setCpf(" ");
		em.merge(pedagogo);

	}

	@Test(expected = PersistenceException.class)
	public void testAtualizarGrupoParaNull() {
		pedagogo.setGrupo(Null);
		em.merge(pedagogo);

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarGrupoParaVazio() {
		pedagogo.setGrupo(" ");
		em.merge(pedagogo);
	}

	// // ========================Remover
	// Pedagogo===============================

	@Test(expected = AssertionError.class)
	public void testRemoverMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.remove(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testRemoverMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.remove(pedagogo);
	}

	@Test(expected = AssertionError.class)
	public void testRemoverPedagogoNull() {
		pedagogo = new Pedagogo();
		em.remove(pedagogo);
	}

	// ================== Buscar Matricula =================

	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogo() throws SisapException {
		String mat = "pedagogo";
		Long matricula = Long.parseLong(mat);
		Pedagogo p = pedagogoDAO.buscarPorMatricula(matricula);
		assertEquals(p, pedagogo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogoMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.find(Pedagogo.class, pedagogo.getMatriculaSuap());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogoMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.find(Pedagogo.class, pedagogo.getMatriculaSuap());

	}
}