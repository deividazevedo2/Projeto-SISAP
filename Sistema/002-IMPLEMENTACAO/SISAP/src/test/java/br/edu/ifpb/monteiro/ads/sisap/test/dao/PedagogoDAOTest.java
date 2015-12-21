package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.entities.Sexo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PedagogoDAOTest {

	private static final String Null = null;
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static PedagogoDAO pedagogoDAO;
	private static Pedagogo pedagogo;

	public PedagogoDAOTest() {
	}

	// @Before
	// public void setUp() throws Exception {
	// super.setUp();
	// int year = 1995;
	// int month = 1;
	// int day = 10;
	//
	// dog01 = new Dog("Yellow", 3.5d, createNewDate(day, month, year));
	// dog02 = new Dog("Brown", 8.5d, createNewDate(++day, ++month, ++year));
	// dog03 = new Dog("Dark", 15.5d, createNewDate(++day, ++month, ++year));
	// dog04 = new Dog("Kaka", 4.3d, createNewDate(++day, ++month, ++year));
	// dog05 = new Dog("Pepe", 8.2d, createNewDate(++day, ++month, ++year));
	// dog06 = new Dog("Casillas", 6.1d, createNewDate(++day, ++month, ++year));
	// dog07 = new Dog("Fish", 6.7d, createNewDate(++day, ++month, ++year));
	// dog08 = new Dog("Lion", 3.1d, createNewDate(++day, ++month, ++year));
	// dog09 = new Dog("Cat", 5.5d, createNewDate(++day, ++month, ++year));
	// }

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
		List<Contato> contatos = new ArrayList<Contato>();
		contato.setEmail("cassio@gmail.com");
		contatos.add(contato);
		
		pedagogo.setContatos(contatos);
		pedagogo.setMatriculaSuap("65050265265201");
		pedagogo.setSexo(Sexo.MASCULINO);
		pedagogo.setPrimeiroNome("Widancassio");
		pedagogo.setSegundoNome("Galindo");
		pedagogo.setCpf("000020000111");
		pedagogo.setEndereco(endereco);
		pedagogo.setSenha("pedagogo");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoNull() {
		Pedagogo p1 = new Pedagogo();
		em.persist(p1);
		assertNull(em);

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoPrimeiroNomeVazio() {
		pedagogo.setPrimeiroNome(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoPrimeiroNomeComNull() {
		pedagogo.setPrimeiroNome(Null);
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");
	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoSegundoNomeVazio() {
		pedagogo.setSegundoNome(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoRGVazio() {
		pedagogo.setRg(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoRGNull() {
		pedagogo.setRg(Null);
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoCPFVazio() {
		pedagogo.setCpf(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoCPFNull() {
		pedagogo.setCpf(Null);
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComSenhaNull() {
		pedagogo.setSenha(Null);
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testSalvarPedagogoComSenhaVazia() {
		pedagogo.setSenha(" ");
		em.persist(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	//
	// @Test
	// public void testSalvarLetraNaMatriculSuap() {
	//
	// }

	//
	// //===================Parte de Atualizar ====================

	@Test(expected = AssertionError.class)
	public void testAtualizarMatriculaParaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarMatriculaParaVazio() {
		pedagogo.setMatriculaSuap(" ");
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarNomeParaNull() {
		pedagogo.setPrimeiroNome(Null);
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarNomeParaVazio() {
		pedagogo.setSegundoNome(" ");
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarSenhaParaNull() {
		pedagogo.setSenha(Null);
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarSenhaParaVazio() {
		pedagogo.setSenha(" ");
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarCpfParaNull() {
		pedagogo.setCpf(Null);
		em.merge(pedagogo);
		fail("Erro ao salvar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarCpfParaVazio() {
		pedagogo.setCpf(" ");
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarGrupoParaNull() {
		pedagogo.setGrupo(Null);
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testAtualizarGrupoParaVazio() {
		pedagogo.setGrupo(" ");
		em.merge(pedagogo);
		fail("Erro ao Atualizar o cadastro!");

	}

	// // ========================Remover
	// Pedagogo===============================

	@Test(expected = AssertionError.class)
	public void testRemoverMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.remove(pedagogo);
		fail("Erro ao remover o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testRemoverMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.remove(pedagogo);
		fail("Erro ao remover o cadastro!");

	}

	@Test(expected = AssertionError.class)
	public void testRemoverPedagogoNull() {
		pedagogo = new Pedagogo();
		em.remove(pedagogo);
		fail("Erro ao remover o cadastro!");

	}

	// ================== Buscar Matricula =================

	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogo() throws SisapException{
		Pedagogo p = pedagogoDAO.buscarPorMatricula("65050265265201");
		assertEquals(p, pedagogo);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogoMatriculaNull() {
		pedagogo.setMatriculaSuap(Null);
		em.find(Pedagogo.class, pedagogo.getMatriculaSuap());
		fail("Erro ao buscar o cadastro!");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testBuscarPedagogoMatriculaVazia() {
		pedagogo.setMatriculaSuap(" ");
		em.find(Pedagogo.class, pedagogo.getMatriculaSuap());
		fail("Erro ao buscar o cadastro!");

	}
}

	// // ===================== Busca por ID ========================
	//
	//
	//
	// @Test
	// public void testBuscarIDNull() {
	//
	//
	// }
	//
	// @Test
	// public void testbuscarIDInexistente() {
	//
	//
	// }
	// @Test
	// public void testIDVazia() {
	//
	//
	// }

	// @Test(expected = IllegalArgumentException.class)
	// public void character04() {
	//
	// int[] a = {};
	// la.getMaior(a);
	// }
	//
	//
	//
	// @Test
	// public void testSalvarPedagogoNomeNulo() {
	// String fb = pedagogoDAO.salvar();
	// fizzBuzz.calculate(20);
	// assertEquals("Esperasse BUZZ",fizzBuzz.BUZZ, fb);
	// }
	//
