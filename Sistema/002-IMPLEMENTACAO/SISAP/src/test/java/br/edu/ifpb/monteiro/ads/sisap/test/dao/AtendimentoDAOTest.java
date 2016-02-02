package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.AtendimentoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class AtendimentoDAOTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static AtendimentoDAO atendimentoDAO;
	private static Atendimento atendimento;

	public AtendimentoDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		atendimentoDAO = new AtendimentoDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		atendimentoDAO.setEntityManager(em);

		atendimento = new Atendimento();

		Aluno aluno = new Aluno();

		Responsavel responsavel = new Responsavel();
		responsavel.setNome("Paiô");

		aluno.setNome("meu nome");
		aluno.setMae("Mainha");
		aluno.setMatricula("1234");
		aluno.setPai("Painho");

		responsavel.setAluno(aluno);
		em.persist(responsavel);

		aluno.setResponsavel(responsavel);
		em.persist(aluno);

		atendimento.setAluno(aluno);
		atendimento.setAtendido("Pessoa Atendida");
		atendimento.setData("12/12/2012");
		atendimento.setDescricao("Descricao do atendimento");
		atendimento.setMedidasAnteriores("Medidas anteriores");
		atendimento.setMedidasPosteriores("Medidas posteriores");
		atendimento.setObservacoes("Observacoes do atendimento");
		atendimento.setSituacao("Concluido");
		atendimento.setSolicitante("Professor Joao");
		atendimento.setId(100);

	}

	@Test
	public void buscarPedagogoIdInvalido() {

		try {

			atendimento = em.find(Atendimento.class, 100);

			assertNull("Resultado deveria ser nulo.", atendimento);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	// @Test
	// public void buscarPedagogoMatriculaInvalida() {
	// try {
	// atendimento = atendimentoDAO.buscarPorMatricula("234521");
	//
	// assertNull("Resultado deveria ser nulo.", atendimento);
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// @Test
	// public void buscarPedagogoIdNull() {
	// try {
	// atendimento = atendimentoDAO.buscarPorId(null);
	//
	// assertNull("Resultado deveria ser nulo.", atendimento);
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void buscarPedagogoMatriculaNull() {
	// try {
	// atendimento = atendimentoDAO.buscarPorMatricula(null);
	//
	// assertNull("Resultado deveria ser nulo.", atendimento);
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void buscarPedagogoPorMatricula() {
	// try {
	// atendimento = atendimentoDAO.buscarPorMatricula("65050265265208");
	//
	// assertEquals("Widancassio", atendimento.getPrimeiroNome());
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void buscarPedagogoPorId() {
	// try {
	// atendimento = atendimentoDAO.buscarPorId(Long.parseLong("1"));
	//
	// assertEquals("Galindo", atendimento.getSegundoNome());
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void atualizarPrimeiroNome() {
	// try {
	// atendimento = atendimentoDAO.buscarPorId(Long.parseLong("1"));
	//
	// // Procurando o pedagogo e comparando o primeiro nome dele até o
	// // momento
	// assertEquals("Widancassio", atendimento.getPrimeiroNome());
	//
	// // Alterando o primeiro nome do pedagogo
	// atendimento.setPrimeiroNome("Felipe");
	//
	// // Salvando a alteracao do cadastro de pedagogo
	// atendimentoDAO.atualizar(atendimento);
	//
	// // Procurando o pedagogo já com a alteração feita
	// Pedagogo alterado = atendimentoDAO.buscarPorId(Long.parseLong("1"));
	//
	// // Comparando se o novo nome do pedagogo foi alterado
	// assertEquals("Felipe", alterado.getPrimeiroNome());
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void atualizarContatoEmail() {
	// try {
	// // Buscando o pedagogo pela matricula
	// atendimento = atendimentoDAO.buscarPorMatricula("65050265265208");
	//
	// // Buscando o contato deste pedagogo
	// Contato c = atendimento.getContato();
	//
	// // Verificando o email do pedagogo
	// assertEquals("cassio@gmail.com", c.getEmail());
	//
	// // Setando novo valor do contato email para o pedagogo e adicionando
	// // ao seu cadastro
	// c.setEmail("novo@email.com");
	// atendimento.setContato(c);
	//
	// // atualizando o cadastro de pedagogo com o email alterado
	// atendimentoDAO.atualizar(atendimento);
	//
	// // Buscando o pedagogo que foi alterado
	// Pedagogo alterado = atendimentoDAO
	// .buscarPorMatricula("65050265265208");
	//
	// // Buscando o contato do pedagogo onde foi alterado o email
	// Contato novo = alterado.getContato();
	//
	// // comparando agora o novo email que foi adicionado e salvo no
	// // pedagogo
	// assertEquals("novo@email.com", novo.getEmail());
	//
	// } catch (SisapException e) {
	// e.printStackTrace();
	// }
	// }

}