import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Boletim;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class MainAddAluno {

	private static final Log LOGGER = LogFactory.getLog(MainAddAluno.class);

	static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

	static ArrayList<Contato> contatos = new ArrayList<Contato>();
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<String> cursos = new ArrayList<String>();
	static List<String> disciplinasDeADS;
	static List<String> disciplinasDeConstrucao;
	static List<String> disciplinasDeMSI;
	static List<String> disciplinasDeMusica;
	static ArrayList<Double> notasVariadas = new ArrayList<Double>();
	static ArrayList<Boletim> boletins;
	static ArrayList<Boletim> boletinsSalvosNoBanco;

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

				boletinsSalvosNoBanco = new ArrayList<Boletim>();

				retornaBoletins(alunos.get(j));

				for (Boletim b : boletins) {
					em.persist(b);
					boletinsSalvosNoBanco.add(em.find(Boletim.class, i));

					i++;
				}

				alunos.get(j).setBoletim(boletins);

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

			cursos.add("Análise e Desenvolvimento de Sistemas");
			cursos.add("Construção de Edifícios");
			cursos.add("Manutenção e Suporte de Informática");
			cursos.add("Música");

			Collections.shuffle(cursos);

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
			aluno.setCurso(cursos.get(1));

			contatos.get(i - 1).setAluno(aluno);

			aluno.setContato(contatos.get(i - 1));

			responsavel.setContato(contatos.get(i - 1));

			aluno.setResponsavel(responsavel);

			alunos.add(aluno);
		}

	}

	private static void retornaBoletins(Aluno aluno) {

		notasVariadas.add(4.5);
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

			if (aluno.getCurso()
					.equals("Análise e Desenvolvimento de Sistemas")) {
				adicionaDisciplinasADS(aluno);
			} else if (aluno.getCurso().equals("Construção de Edifícios")) {
				adicionaDisciplinasConstrucao(aluno);
			} else if (aluno.getCurso().equals(
					"Manutenção e Suporte de Informática")) {
				adicionaDisciplinasMSI(aluno);
			} else if (aluno.getCurso().equals("Música")) {
				adicionaDisciplinasMusica(aluno);
			}

		}

	}

	private static void adicionaDisciplinasADS(Aluno aluno) {

		boletins = new ArrayList<Boletim>();

		disciplinasDeADS = new ArrayList<String>();

		disciplinasDeADS.add("Matematica Básica");
		disciplinasDeADS.add("Português Instrumental");
		disciplinasDeADS.add("Inglês I");
		disciplinasDeADS.add("Inglês II");
		disciplinasDeADS.add("Programação I");
		disciplinasDeADS.add("Programação II");
		disciplinasDeADS.add("Banco de Dados I");
		disciplinasDeADS.add("Banco de Dados II");
		disciplinasDeADS.add("Padrões de Projeto");
		disciplinasDeADS.add("Análise de Algoritmos");
		disciplinasDeADS.add("Projeto I");
		disciplinasDeADS.add("Projeto II");

		Double mediaGeral = 0.0;

		Collections.shuffle(disciplinasDeADS);
		for (int i = 0; i < 7; i++) {

			Boletim boletim = new Boletim();

			boletim.setDisciplina(disciplinasDeADS.get(i));

			Collections.shuffle(notasVariadas);
			boletim.setNotaPrimeiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaSegundoBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaTerceiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaQuartoBimestre(notasVariadas.get(1));

			Double mediaDisciplina = 0.0;
			mediaDisciplina += boletim.getNotaPrimeiroBimestre();
			mediaDisciplina += boletim.getNotaSegundoBimestre();
			mediaDisciplina += boletim.getNotaTerceiroBimestre();
			mediaDisciplina += boletim.getNotaQuartoBimestre();

			mediaDisciplina = mediaDisciplina / 4.0;
			boletim.setMediaDisciplina(mediaDisciplina);
			mediaGeral += mediaDisciplina;

			boletim.setMatricula(aluno.getMatricula());

			boletins.add(boletim);

		}
		mediaGeral = mediaGeral / 7.0;
		aluno.setSituacaoAcademica(situacaoAluno(mediaGeral));

	}

	private static void adicionaDisciplinasMSI(Aluno aluno) {

		boletins = new ArrayList<Boletim>();

		disciplinasDeMSI = new ArrayList<String>();

		disciplinasDeMSI.add("Informática Básica");
		disciplinasDeMSI.add("Informática Avançada");
		disciplinasDeMSI.add("Português");
		disciplinasDeMSI.add("Matemática");
		disciplinasDeMSI.add("Cálculo");
		disciplinasDeMSI.add("Fundamentos de Redes");
		disciplinasDeMSI.add("Introdução à Redes de Computadores");
		disciplinasDeMSI.add("Sistemas para Informática");

		Double mediaGeral = 0.0;

		Collections.shuffle(disciplinasDeMSI);
		for (int i = 0; i < 7; i++) {

			Boletim boletim = new Boletim();
			boletim.setDisciplina(disciplinasDeMSI.get(i));

			Collections.shuffle(notasVariadas);
			boletim.setNotaPrimeiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaSegundoBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaTerceiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaQuartoBimestre(notasVariadas.get(1));

			Double mediaDisciplina = 0.0;
			mediaDisciplina += boletim.getNotaPrimeiroBimestre();
			mediaDisciplina += boletim.getNotaSegundoBimestre();
			mediaDisciplina += boletim.getNotaTerceiroBimestre();
			mediaDisciplina += boletim.getNotaQuartoBimestre();

			mediaDisciplina = mediaDisciplina / 4.0;
			boletim.setMediaDisciplina(mediaDisciplina);
			mediaGeral += mediaDisciplina;

			boletim.setMatricula(aluno.getMatricula());

			boletins.add(boletim);

		}
		mediaGeral = mediaGeral / 7.0;
		aluno.setSituacaoAcademica(situacaoAluno(mediaGeral));

	}

	private static void adicionaDisciplinasConstrucao(Aluno aluno) {

		boletins = new ArrayList<Boletim>();

		disciplinasDeConstrucao = new ArrayList<String>();

		disciplinasDeConstrucao.add("Inglês I");
		disciplinasDeConstrucao.add("Português");
		disciplinasDeConstrucao.add("Física");
		disciplinasDeConstrucao.add("Química");
		disciplinasDeConstrucao.add("Física Quântica");
		disciplinasDeConstrucao.add("Matemática");
		disciplinasDeConstrucao.add("Cálculo Vetorial");
		disciplinasDeConstrucao.add("Álgebra Linear");

		Double mediaGeral = 0.0;

		Collections.shuffle(disciplinasDeConstrucao);
		for (int i = 0; i < 7; i++) {

			Boletim boletim = new Boletim();
			boletim.setDisciplina(disciplinasDeConstrucao.get(i));

			Collections.shuffle(notasVariadas);
			boletim.setNotaPrimeiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaSegundoBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaTerceiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaQuartoBimestre(notasVariadas.get(1));

			Double mediaDisciplina = 0.0;
			mediaDisciplina += boletim.getNotaPrimeiroBimestre();
			mediaDisciplina += boletim.getNotaSegundoBimestre();
			mediaDisciplina += boletim.getNotaTerceiroBimestre();
			mediaDisciplina += boletim.getNotaQuartoBimestre();

			mediaDisciplina = mediaDisciplina / 4.0;
			boletim.setMediaDisciplina(mediaDisciplina);
			mediaGeral += mediaDisciplina;

			boletim.setMatricula(aluno.getMatricula());

			boletins.add(boletim);

		}
		mediaGeral = mediaGeral / 7.0;
		aluno.setSituacaoAcademica(situacaoAluno(mediaGeral));

	}

	private static void adicionaDisciplinasMusica(Aluno aluno) {

		boletins = new ArrayList<Boletim>();

		disciplinasDeMusica = new ArrayList<String>();

		disciplinasDeMusica.add("Notas Musicais I");
		disciplinasDeMusica.add("Canto Lírico");
		disciplinasDeMusica.add("Fundamentos do Sopro");
		disciplinasDeMusica.add("Exemplo de Disciplina de Música");
		disciplinasDeMusica.add("Sopro Avançado I");
		disciplinasDeMusica.add("Sopro Avançado II");
		disciplinasDeMusica.add("Sopro Super Avançado III");
		disciplinasDeMusica.add("Bateria");
		disciplinasDeMusica.add("Violino Básico");

		Double mediaGeral = 0.0;

		Collections.shuffle(disciplinasDeMusica);
		for (int i = 0; i < 7; i++) {

			Boletim boletim = new Boletim();
			boletim.setDisciplina(disciplinasDeMusica.get(i));

			Collections.shuffle(notasVariadas);
			boletim.setNotaPrimeiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaSegundoBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaTerceiroBimestre(notasVariadas.get(1));

			Collections.shuffle(notasVariadas);
			boletim.setNotaQuartoBimestre(notasVariadas.get(1));

			Double mediaDisciplina = 0.0;
			mediaDisciplina += boletim.getNotaPrimeiroBimestre();
			mediaDisciplina += boletim.getNotaSegundoBimestre();
			mediaDisciplina += boletim.getNotaTerceiroBimestre();
			mediaDisciplina += boletim.getNotaQuartoBimestre();

			mediaDisciplina = mediaDisciplina / 4.0;
			boletim.setMediaDisciplina(mediaDisciplina);
			mediaGeral += mediaDisciplina;

			boletim.setMatricula(aluno.getMatricula());

			boletins.add(boletim);
		}
		mediaGeral = mediaGeral / 7.0;
		aluno.setSituacaoAcademica(situacaoAluno(mediaGeral));

	}

	/**
	 * Capturando a situação do aluno com base na media das disciplinas dele.
	 * 
	 * @param media
	 * @return
	 */
	private static String situacaoAluno(Double media) {
		if (media >= 7.0) {
			return "APROVADO";
		} else if (media >= 4 && media <= 6.9) {
			return "MERECE ATENÇÃO";
		}
		return "REPROVADO";
	}
}