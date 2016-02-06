package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.*;
import org.hamcrest.core.Is;

import br.edu.ifpb.monteiro.ads.sisap.dao.AtendimentoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

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

	// @Test
	// public void buscarPedagogoIdInvalido() {
	//
	// try {
	//
	// atendimento = em.find(Atendimento.class, 100);
	//
	// assertNull("Resultado deveria ser nulo.", atendimento);
	//
	// } catch (NumberFormatException e) {
	// e.printStackTrace();
	// }
	//
	// }

	@Test
	public void buscarAtendimentoPorIdInvalido() {
		try {
			atendimento = atendimentoDAO.buscarPorId(1000);

			assertEquals(null, atendimento);

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void atendimentoNaoEncontradoNaLista() {
		try {
			List<Atendimento> atendimentos = atendimentoDAO.getAll("12309445",
					"invalido");

			assertEquals(0, atendimentos.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atendimentoVazioNaoEncontradoNaLista() {
		try {
			List<Atendimento> atendimentos = atendimentoDAO.getAll(" ", "Nome");

			assertNull(atendimentos.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atendimentoNuloNaoEncontradoNaLista() {
		try {
			List<Atendimento> atendimentos = atendimentoDAO.getAll(null, null);

			assertNull(atendimentos.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

}