package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.AlunoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class AlunoDAOTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static AlunoDAO alunoDAO;
	private static Aluno aluno;

	public AlunoDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		alunoDAO = new AlunoDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		alunoDAO.setEntityManager(em);

		aluno = new Aluno();

		Responsavel responsavel = new Responsavel();

		aluno.setNome("meu nome");
		aluno.setMae("Mainha");
		aluno.setMatricula("1234");
		aluno.setPai("Painho");

		responsavel.setAluno(aluno);
		aluno.setResponsavel(responsavel);
		em.persist(aluno);

	}

	@Test
	public void buscarAlunoIdInvalido() {

		try {

			aluno = alunoDAO.buscarPorId(20134);

			assertNull("Resultado deveria ser nulo.", aluno);

		} catch (NumberFormatException | SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarAlunoMatriculaInvalida() {
		try {
			aluno = alunoDAO.buscarPorMatricula("matricula");

			assertNull("Resultado deveria ser nulo.", aluno);

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarAlunoMatriculaNull() {
		try {
			aluno = alunoDAO.buscarPorMatricula(null);

			assertNull("Resultado deveria ser nulo.", aluno);

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarAlunoPorId() {
		try {
			aluno = alunoDAO.buscarPorId(100);

			assertNull(aluno);

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void alunoNaoEncontradoNaListagem() {
		try {
			List<Aluno> alunos = alunoDAO.getAll("invalida", "invalido");

			assertEquals(0, alunos.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}
	}
	
	

}