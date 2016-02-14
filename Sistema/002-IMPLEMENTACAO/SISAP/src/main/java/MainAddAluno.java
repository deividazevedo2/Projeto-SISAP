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
import br.edu.ifpb.monteiro.ads.sisap.entities.Bimestre;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class MainAddAluno {

	private static final Log LOGGER = LogFactory.getLog(MainAddAluno.class);

	static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

	static ArrayList<Contato> contatos = new ArrayList<Contato>();
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Bimestre> bimestres;
	static ArrayList<Bimestre> bimestresSalvosNoBanco;

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

				bimestresSalvosNoBanco = new ArrayList<Bimestre>();

				retornaBimestres(alunos.get(j).getMatricula());

				for (Bimestre b : bimestres) {
					em.persist(b);
					bimestresSalvosNoBanco.add(em.find(Bimestre.class, i));

					i++;
				}

				alunos.get(j).setBimestres(bimestres);

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

	private static void retornaBimestres(String matricula) {

		bimestres = new ArrayList<Bimestre>();

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

		for (int i = 0; i < 4; i++) {

			Collections.shuffle(notasVariadas);

			Bimestre bimestre = new Bimestre();
			bimestre.setPortugues(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setMatematica(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setArtes(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setBiologia(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setFilosofia(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setFisica(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setGeografia(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setHistoria(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setQuimica(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			bimestre.setSociologia(notasVariadas.get(1));

			bimestre.setMatricula(matricula);

			bimestres.add(bimestre);
		}

	}

}