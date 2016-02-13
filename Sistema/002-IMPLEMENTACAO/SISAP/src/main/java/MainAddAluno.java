import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Nota;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class MainAddAluno {

	private static final Log LOGGER = LogFactory.getLog(MainAddAluno.class);

	static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

	static ArrayList<Contato> contatos = new ArrayList<Contato>();
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Nota> notas;
	static ArrayList<Nota> notasSalvasNoBanco;

	public static void adicionaAlunos() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			LOGGER.info("Creating data. . . Please wait. . .");
			retornaAluno();

			int i = 1;

			for (int j = 0; j < 200; j++) {

				notas = new ArrayList<Nota>();
				notasSalvasNoBanco = new ArrayList<Nota>();

				retornaNotas();

				for (Nota n : notas) {
					em.persist(n);
					notasSalvasNoBanco.add(em.find(Nota.class, i));

					retornaNotas();
					i++;
				}

				alunos.get(j).setNotas(notasSalvasNoBanco);
				em.persist(alunos.get(j));
			}

			LOGGER.info("SUCESS!");
		} catch (RollbackException ex) {
			LOGGER.warn("FAIL", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}
	}

	private static Endereco retornaEndereco() {

		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setCep("58540-000");
		endereco.setCidade("Monteiro");
		endereco.setRua("Rua Exemplo");
		endereco.setUf("PB");

		for (int i = 1; i <= 200; i++) {
			endereco.setNumero(i);
			enderecos.add(endereco);

		}

		Collections.shuffle(enderecos);

		return enderecos.get(1);
	}

	private static void retornaContato(Contato contato, Integer i) {

		String e = String.valueOf(i);
		contato.setEmail("emailnumero" + e + "@exemplo.com");
		contato.setFacebok("Facebook " + e);
		contato.setTwitter("Twitter " + e);
		contatos.add(contato);
	}

	private static void retornaAluno() {

		Integer matricula = 2012250219;

		for (int i = 1; i <= 200; i++) {

			Aluno aluno = new Aluno();
			aluno.setEndereco(retornaEndereco());

			Responsavel responsavel = new Responsavel();
			responsavel.setNome("Nome do Responsavel");
			responsavel.setGrauDeInstrucao("Grau de Instrucao aqui");
			responsavel.setGrauDeParentesco("Grau de Parentesco aqui");
			responsavel.setEndereco(retornaEndereco());

			Contato contato = new Contato();
			contato.setCelular("12345678900");
			contato.setTelefoneResidencial("12345678900");
			contato.setTelefoneTrabalho("12345678900");

			retornaContato(contato, i);

			aluno.setNome("Aluno " + String.valueOf(i));
			aluno.setMatricula(String.valueOf(matricula + (i + 1)));
			aluno.setResponsavel(responsavel);

			contatos.get(i - 1).setAluno(aluno);

			aluno.setContato(contatos.get(i - 1));

			responsavel.setContato(contatos.get(i - 1));

			aluno.setResponsavel(responsavel);

			alunos.add(aluno);
		}

	}

	private static void retornaNotas() {

		ArrayList<String> disciplinas = new ArrayList<String>();
		disciplinas.add("Matematica");
		disciplinas.add("Português");
		disciplinas.add("Artes");
		disciplinas.add("Biologia");
		disciplinas.add("Geografia");
		disciplinas.add("História");
		disciplinas.add("Física");
		disciplinas.add("Química");
		disciplinas.add("Sociologia");
		disciplinas.add("Filosofia");

		ArrayList<Double> notasVariadas = new ArrayList<Double>();
		notasVariadas.add(0.0);
		notasVariadas.add(3.0);
		notasVariadas.add(4.0);
		notasVariadas.add(4.5);
		notasVariadas.add(5.0);
		notasVariadas.add(5.5);
		notasVariadas.add(6.0);
		notasVariadas.add(6.5);
		notasVariadas.add(7.0);
		notasVariadas.add(8.0);
		notasVariadas.add(8.5);
		notasVariadas.add(9.0);
		notasVariadas.add(10.0);

		notas = new ArrayList<Nota>();

		int n = 0;
		for (int i = 0; i < 10; i++) {

			int valor = 0;

			for (int j = valor; j < 4; j++) {

				Collections.shuffle(notasVariadas);

				Nota nota = new Nota();
				nota.setData("06/08/2011");
				nota.setDisciplina(disciplinas.get(n));
				nota.setNota(notasVariadas.get(1));

				notas.add(nota);
			}
			n++;

		}

	}

}