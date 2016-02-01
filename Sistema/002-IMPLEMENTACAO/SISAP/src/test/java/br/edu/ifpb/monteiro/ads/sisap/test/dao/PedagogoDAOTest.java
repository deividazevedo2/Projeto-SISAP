package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class PedagogoDAOTest {

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

	@Test
	public void buscarPedagogoIdInvalido() {

		try {

			pedagogo = pedagogoDAO.buscarPorId(Long.parseLong("90"));

			assertNull("Resultado deveria ser nulo.", pedagogo);

		} catch (NumberFormatException | SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarPedagogoMatriculaInvalida() {
		try {
			pedagogo = pedagogoDAO.buscarPorMatricula("234521");

			assertNull("Resultado deveria ser nulo.", pedagogo);

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarPedagogoIdNull() {
		try {
			pedagogo = pedagogoDAO.buscarPorId(null);

			assertNull("Resultado deveria ser nulo.", pedagogo);

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buscarPedagogoMatriculaNull() {
		try {
			pedagogo = pedagogoDAO.buscarPorMatricula(null);

			assertNull("Resultado deveria ser nulo.", pedagogo);

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buscarPedagogoPorMatricula() {
		try {
			pedagogo = pedagogoDAO.buscarPorMatricula("65050265265208");

			assertEquals("Widancassio", pedagogo.getPrimeiroNome());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buscarPedagogoPorId() {
		try {
			pedagogo = pedagogoDAO.buscarPorId(Long.parseLong("1"));

			assertEquals("Galindo", pedagogo.getSegundoNome());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atualizarPrimeiroNome() {
		try {
			pedagogo = pedagogoDAO.buscarPorId(Long.parseLong("1"));

			// Procurando o pedagogo e comparando o primeiro nome dele até o
			// momento
			assertEquals("Widancassio", pedagogo.getPrimeiroNome());

			// Alterando o primeiro nome do pedagogo
			pedagogo.setPrimeiroNome("Felipe");

			// Salvando a alteracao do cadastro de pedagogo
			pedagogoDAO.atualizar(pedagogo);

			// Procurando o pedagogo já com a alteração feita
			Pedagogo alterado = pedagogoDAO.buscarPorId(Long.parseLong("1"));

			// Comparando se o novo nome do pedagogo foi alterado
			assertEquals("Felipe", alterado.getPrimeiroNome());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atualizarContatoEmail() {
		try {
			// Buscando o pedagogo pela matricula
			pedagogo = pedagogoDAO.buscarPorMatricula("65050265265208");

			// Buscando o contato deste pedagogo
			Contato c = pedagogo.getContato();

			// Verificando o email do pedagogo
			assertEquals("cassio@gmail.com", c.getEmail());

			// Setando novo valor do contato email para o pedagogo e adicionando
			// ao seu cadastro
			c.setEmail("novo@email.com");
			pedagogo.setContato(c);

			// atualizando o cadastro de pedagogo com o email alterado
			pedagogoDAO.atualizar(pedagogo);

			// Buscando o pedagogo que foi alterado
			Pedagogo alterado = pedagogoDAO
					.buscarPorMatricula("65050265265208");

			// Buscando o contato do pedagogo onde foi alterado o email
			Contato novo = alterado.getContato();

			// comparando agora o novo email que foi adicionado e salvo no
			// pedagogo
			assertEquals("novo@email.com", novo.getEmail());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}
	
}