package br.edu.ifpb.monteiro.ads.sisap.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpb.monteiro.ads.sisap.dao.ReuniaoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class ReuniaoDAOTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static ReuniaoDAO reuniaoDAO;
	private static Reuniao reuniao;

	public ReuniaoDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		reuniaoDAO = new ReuniaoDAO();
		emf = Persistence.createEntityManagerFactory("SISAP");
		em = emf.createEntityManager();
		reuniaoDAO.setEntityManager(em);

		reuniao = new Reuniao();
		reuniao.setDataDeAgendamento("05/04/2016");
		reuniao.setDataDeFinalizacao("06/04/2016");
		reuniao.setDescricao("Reuniao descricao");
		reuniao.setObjetivo("Objetivo Reuniao");
		reuniao.setPauta("Pauta reuniao");
		reuniao.setSituacao("Maria");
		reuniao.setSolicitante("Solicitante");
		em.persist(reuniao);

	}

	@Test
	public void buscarReuniaoComIdInvalido() {

		try {

			reuniao = reuniaoDAO.buscarPorId(1223);

			assertNull("Ocorreu um problema ao buscar o reuniao!", reuniao);

		} catch (NumberFormatException | SisapException e) {
			e.printStackTrace();
		}

	}

	
	@Test
	public void buscarReuniaoComSituacaoInvalida() {
		try {
					
			List<Reuniao> r = reuniaoDAO.getAll();
			assertNotEquals(1000, r.size());

		} catch (SisapException e) {
			e.printStackTrace();
		}

	}

//	@Test
//	public void buscarAlunoPorId() {
//		try {
//			aluno = alunoDAO.buscarPorId(100);
//
//			assertNull(aluno);
//
//		} catch (SisapException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void alunoNaoEncontradoNaListagem() {
//		try {
//			List<Aluno> alunos = alunoDAO.getAll("invalida", "invalido");
//
//			assertEquals(0, alunos.size());
//
//		} catch (SisapException e) {
//			e.printStackTrace();
//		}
//	}

}