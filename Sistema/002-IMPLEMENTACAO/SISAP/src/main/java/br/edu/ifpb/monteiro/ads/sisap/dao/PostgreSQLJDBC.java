package br.edu.ifpb.monteiro.ads.sisap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PostgreSQLJDBC {

	public void generateData() {

		Connection c = null;
		Statement stmt = null;
		try {

			// Criando uma lista de nomes
			ArrayList<String> nomes = new ArrayList<String>();
			nomes.add("Deivid Azevedo de Lima");
			nomes.add("Indy Paula Soares Cordeiro e Silva");
			nomes.add("Widancássio Galindo da Silva");
			nomes.add("Jaindson Valentim Santana");
			nomes.add("Giuseppe Anthony");
			nomes.add("Ednaldo Dilorenzo");
			nomes.add("Luiz Antonio Pereira da Silva");
			nomes.add("José Joaquim Cintra Maia Honório");

			// Embaralhando a lista de nomes
			Collections.shuffle(nomes);

			// Criando uma lista de Emails
			ArrayList<String> emails = new ArrayList<String>();
			emails.add("email01@email.com");
			emails.add("exemplo02@exemplo.com.br");
			emails.add("email03@exemplo.com.br");
			emails.add("email@hotmail.com");
			emails.add("novoemail@gmail.com.br");
			emails.add("email04@email.com.br");
			emails.add("email05@email.com");
			emails.add("email06@email.com.br");

			// Criando uma lista de disciplinas
			ArrayList<String> disciplinas = new ArrayList<String>();
			disciplinas.add("Matematica Básica");
			disciplinas.add("Português");
			disciplinas.add("Quimica");
			disciplinas.add("Física");
			disciplinas.add("Artes");
			disciplinas.add("História");
			disciplinas.add("Álgebra");
			disciplinas.add("Cálculo Vetorial");
			disciplinas.add("Artes");
			disciplinas.add("Ciências");
			disciplinas.add("Outra disciplina");

			// Criando uma lista de Períodos/Séries
			ArrayList<String> periodoSerie = new ArrayList<String>();
			periodoSerie.add("1 ano");
			periodoSerie.add("2 ano");
			periodoSerie.add("3 ano");
			periodoSerie.add("1 periodo");
			periodoSerie.add("2 periodo");
			periodoSerie.add("3 periodo");
			periodoSerie.add("4 periodo");
			periodoSerie.add("5 periodo");
			periodoSerie.add("6 periodo");
			periodoSerie.add("7 periodo");

			// Criando uma lista de ano/periodo letivo
			ArrayList<String> anoPeriodoLetivo = new ArrayList<String>();
			anoPeriodoLetivo.add("2012.1");
			anoPeriodoLetivo.add("2012.2");
			anoPeriodoLetivo.add("2013.1");
			anoPeriodoLetivo.add("2013.2");
			anoPeriodoLetivo.add("2014.1");
			anoPeriodoLetivo.add("2014.2");
			anoPeriodoLetivo.add("2015.1");
			anoPeriodoLetivo.add("2015.2");
			anoPeriodoLetivo.add("2016.1");
			anoPeriodoLetivo.add("2016.2");

			// Criando uma lista de Salas
			ArrayList<String> salas = new ArrayList<String>();
			salas.add("Sala 1 Bloco A");
			salas.add("Sala 2 Bloco B");
			salas.add("Sala 3 Bloco C");
			salas.add("Sala 4 Bloco D");
			salas.add("Sala 5 Bloco A");
			salas.add("Sala 6 Bloco B");
			salas.add("Sala 7 Bloco C");
			salas.add("Sala 8 Bloco D");
			salas.add("Sala 9 Bloco A");
			salas.add("Sala 10 Bloco B");
			salas.add("Sala 11 Bloco C");
			salas.add("Sala 12 Bloco D");

			// Criando uma lista de Conteudos de Aula
			ArrayList<String> conteudo = new ArrayList<String>();
			conteudo.add("Conteudo 01");
			conteudo.add("Conteudo 02");
			conteudo.add("Conteudo 03");
			conteudo.add("Conteudo 04");
			conteudo.add("Conteudo 05");
			conteudo.add("Conteudo 06");
			conteudo.add("Conteudo 07");
			conteudo.add("Conteudo 08");
			conteudo.add("Conteudo 00");
			conteudo.add("Conteudo 10");

			// Criando uma lista de Datas
			ArrayList<String> datas = new ArrayList<String>();
			datas.add("12/12/2012");
			datas.add("20/09/2013");
			datas.add("08/11/2014");
			datas.add("09/10/2012");
			datas.add("31/03/2011");
			datas.add("19/01/2010");
			datas.add("11/06/2015");
			datas.add("04/08/2015");
			datas.add("30/12/2016");
			datas.add("20/02/2013");
			datas.add("31/07/2014");

			// Criando uma lista de Maes
			ArrayList<String> maes = new ArrayList<String>();
			maes.add("Dona Creuza");
			maes.add("Maria Joaquina");
			maes.add("Bernadete Filipino");
			maes.add("Josefa Cristina");
			maes.add("Maricota da Silva");

			// Criando uma lista de Pais
			ArrayList<String> pais = new ArrayList<String>();
			pais.add("Zé da Carroça");
			pais.add("Joaquim Nabuco");
			pais.add("Pedro Álvares Cabral");
			pais.add("Seu Francisco");
			pais.add("José de Dona Creuza");

			// Criando uma lista de Grau de Instrução
			ArrayList<String> grauDeInstrucao = new ArrayList<String>();
			grauDeInstrucao.add("Fundamental Incompleto");
			grauDeInstrucao.add("Fundamental Completo");
			grauDeInstrucao.add("Médio Incompleto");
			grauDeInstrucao.add("Médio Completo");
			grauDeInstrucao.add("Superior Incompleto");
			grauDeInstrucao.add("Superior Completo");

			// Criando uma lista de Grau de Parentesco
			ArrayList<String> grauDeParentesco = new ArrayList<String>();
			grauDeParentesco.add("Irmão/Irmã");
			grauDeParentesco.add("Pai/Mãe");
			grauDeParentesco.add("Padrasto/Madrasta");
			grauDeParentesco.add("Tio/Tia");
			grauDeParentesco.add("Primo/Prima");
			grauDeParentesco.add("Avô/Avó");

			// Criando uma lista de Assuntos de Avaliações
			ArrayList<String> assunto = new ArrayList<String>();
			assunto.add("Equação");
			assunto.add("Regra de Três Composta");
			assunto.add("A origem da vida");
			assunto.add("Organograma");
			assunto.add("Pegadinha do Malandro");
			assunto.add("Oração Subordinada Adjetiva");
			assunto.add("Como manipular colher de pedreiro");
			assunto.add("Assunto novo qualquer");
			assunto.add("Mitocôndrias");
			assunto.add("Primeira Guerra Mundial");
			assunto.add("A história do Brasil");
			assunto.add("África e seus conceitos");
			assunto.add("Novo assunto qualquer só pra preencher esse campo");
			assunto.add("Aqui é um novo assunto só pra dizer que preencheu");
			assunto.add("Elementos computacionais");
			assunto.add("Testando mais um assunto novo");
			assunto.add("Prova surpresa MUHAHA");
			assunto.add("Padrões de Projeto");
			assunto.add("Diagramas UML");
			assunto.add("Os Sinos de Belém");

			// Criando uma lista de notas de avaliação para aluno
			ArrayList<Double> notas = new ArrayList<Double>();
			notas.add(0.0);
			notas.add(1.0);
			notas.add(1.5);
			notas.add(2.0);
			notas.add(2.5);
			notas.add(3.5);
			notas.add(4.0);
			notas.add(5.0);
			notas.add(5.5);
			notas.add(6.0);
			notas.add(6.5);
			notas.add(7.0);
			notas.add(7.5);
			notas.add(8.0);
			notas.add(8.5);
			notas.add(9.0);
			notas.add(9.1);
			notas.add(9.5);
			notas.add(10.0);
			notas.add(10.0);

			// Criando lista para codigo de curso
			ArrayList<String> codigoDeCurso = new ArrayList<String>();
			codigoDeCurso.add("12345");
			codigoDeCurso.add("67890");
			codigoDeCurso.add("54321");
			codigoDeCurso.add("09876");
			codigoDeCurso.add("39610");

			// Criando lista de nomes de curso
			ArrayList<String> nomesDeCurso = new ArrayList<String>();
			nomesDeCurso.add("Subsequente de Informática");
			nomesDeCurso.add("Análise e Desenvolvimento de Sistemas");
			nomesDeCurso.add("Construção de Edificios");
			nomesDeCurso.add("Enfermagem");
			nomesDeCurso.add("Direito");

			// Criando lista de Turno de cursos
			ArrayList<String> turno = new ArrayList<String>();
			turno.add("Manhã");
			turno.add("Tarde");
			turno.add("Noite");
			turno.add("Integral");
			turno.add("Manhã e Tarde");

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/SISAP", "postgres",
					"boisemsede2");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			String sql;

			// FOR para adicionar contatos aleatórios
			for (int i = 1; i <= 200; i++) {

				Collections.shuffle(emails);

				sql = "INSERT INTO TB_CONTATO (id, celular, email, facebok, "
						+ "telefoneresidencial, telefonetrabalho, twitter) "
						+ "VALUES ("
						+ (i + 1)
						+ ", '00000000000',"
						+ " '"
						+ emails.get(1)
						+ "', 'facebook.com/exemplo', '1234567890', '1234567890', 'twitter.com/exemplo');";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar disciplinas aleatórias
			for (int i = 1; i <= 50; i++) {

				Collections.shuffle(disciplinas);
				Collections.shuffle(periodoSerie);

				sql = "INSERT INTO TB_DISCIPLINA (id, carga_horaria_em_hora_aula, carga_horaria_em_hora_relogio, "
						+ "disponivel, horario, nome, periodo_serie) "
						+ "VALUES ("
						+ i
						+ ", '100', '100', true, '10h00', '"
						+ disciplinas.get(1)
						+ "', '"
						+ periodoSerie.get(1)
						+ "');";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar turmas aleatórias
			for (int i = 1; i <= 50; i++) {

				Collections.shuffle(anoPeriodoLetivo);
				Collections.shuffle(salas);

				Random r = new Random();
				int disciplina = r.nextInt(49);

				sql = "INSERT INTO TB_TURMA(id, ano_periodo_letivo, horario, sala, disciplina_fk) "
						+ "VALUES ("
						+ i
						+ ", '"
						+ anoPeriodoLetivo.get(1)
						+ "', '10h00',"
						+ " '"
						+ salas.get(1)
						+ "', "
						+ (disciplina + 1) + ");";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar responsáveis aleatórios
			for (int i = 1; i <= 200; i++) {

				Collections.shuffle(grauDeInstrucao);
				Collections.shuffle(grauDeParentesco);
				Collections.shuffle(nomes);

				Random r = new Random();
				int contato = r.nextInt(199);

				sql = "INSERT INTO TB_RESPONSAVEL (id, grau_de_instrucao, grau_de_parentesco, "
						+ "nome, rua, numero, bairro, cidade, cep, uf, contato_fk) "
						+ "VALUES ("
						+ i
						+ ", '"
						+ grauDeInstrucao.get(1)
						+ "', '"
						+ grauDeParentesco.get(1)
						+ "', '"
						+ nomes.get(1)
						+ "', 'Rua Exemplo', 201, 'Centro', 'Monteiro', '12345-000', 'PB', "
						+ (contato + 1) + ");";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar alunos aleatórios
			Integer matricula = 2013228947;
			for (int i = 1; i <= 400; i++) {

				Collections.shuffle(nomes);
				Collections.shuffle(maes);
				Collections.shuffle(pais);

				Random r = new Random();
				int responsaveis = r.nextInt(199);
				int contatos = r.nextInt(199);
				int turmas = r.nextInt(49);

				sql = "INSERT INTO TB_ALUNO(id, matricula, nome, mae, pai, "
						+ "contato_fk, responsavel_fk, turma_fk, rua, numero, bairro, "
						+ "cidade, cep, uf) "
						+ "VALUES ("
						+ i
						+ ", '"
						+ ((matricula++) + "")
						+ "', '"
						+ nomes.get(1)
						+ "', '"
						+ maes.get(1)
						+ "', '"
						+ pais.get(1)
						+ "', "
						+ (contatos + 1)
						+ ", "
						+ (responsaveis + 1)
						+ ", "
						+ (turmas + 1)
						+ ", 'Exemplo de Rua', 187, 'Centro', 'Recife', '12344-231', 'PE');";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar aulas aleatórias
			for (int i = 1; i <= 1000; i++) {

				Collections.shuffle(conteudo);
				Collections.shuffle(datas);

				Random r = new Random();
				int alunos = r.nextInt(299);
				int turmas = r.nextInt(49);

				sql = "INSERT INTO TB_AULA (id, conteudo, data, aluno_fk, turma_fk) "
						+ "VALUES ("
						+ i
						+ ", '"
						+ conteudo.get(1)
						+ "', '"
						+ datas.get(1)
						+ "', "
						+ (alunos + 1)
						+ ", "
						+ (turmas + 1) + ");";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar avaliações aleatórias
			for (int i = 1; i <= 150; i++) {

				Collections.shuffle(assunto);
				Collections.shuffle(datas);

				Random r = new Random();
				int turmas = r.nextInt(49);

				sql = "INSERT INTO tb_avaliacao(id, assunto, data, turma_fk) "
						+ "VALUES (" + i + ", '" + assunto.get(1) + "', '"
						+ datas.get(1) + "', " + (turmas + 1) + ");";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar notas de avaliações aleatórias
			Integer id = 1;

			for (int i = 1; i <= 400; i++) {

				for (int j = 1; j <= 5; j++) {

					Collections.shuffle(notas);

					Random r = new Random();
					int avaliacao = r.nextInt(149);
					int disciplina = r.nextInt(49);

					sql = "INSERT INTO tb_nota_de_avaliacao(id, comentario, nota, aluno_fk, avaliacao_fk, disciplina_fk) "
							+ "VALUES ("
							+ id
							+ ", 'Comentário para esta nota'"
							+ ", "
							+ notas.get(1)
							+ ", "
							+ i
							+ ", "
							+ (avaliacao + 1) + ", " + (disciplina + 1) + ");";
					stmt.executeUpdate(sql);

					id++;
				}
			}

			// FOR para adicionar cursos aleatórios
			for (int i = 1; i <= 5; i++) {

				Collections.shuffle(codigoDeCurso);
				Collections.shuffle(nomesDeCurso);
				Collections.shuffle(turno);

				sql = "INSERT INTO TB_CURSO (id, codigo, duracao_meses, nome, sigla, turno) "
						+ "VALUES ("
						+ i
						+ ", '"
						+ codigoDeCurso.get(1)
						+ "', '30', '"
						+ nomesDeCurso.get(1)
						+ "', 'Sigla do Curso Aqui', '" + turno.get(1) + "');";
				stmt.executeUpdate(sql);

			}

			// FOR para adicionar usuarios
			for (int i = 2; i < 3; i++) {

				Random r = new Random();
				int contatos = r.nextInt(199);

				sql = "INSERT INTO tb_pessoa(id, primeiro_nome, segundo_nome, sexo, cpf, rg, "
						+ " matricula, senha, rua, numero, bairro, cidade, "
						+ "cep, uf, contato_fk, tipo_pessoa) "
						+ "VALUES ("
						+ i
						+ ", 'Elenice', 'Sobrenome', 'Feminino', '12323123549', "
						+ "'1273729', '12345', "
						+ "'31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b', "
						+ "'Rua do Pedagogo', 120, 'Centro', 'Monteiro', '12345-032', 'PB',"
						+ (contatos + 1)
						+ ", 'PEDAGOGO');";
				stmt.executeUpdate(sql);

				contatos = r.nextInt(199);
				sql = "INSERT INTO tb_pessoa(id, primeiro_nome, segundo_nome, sexo, cpf, rg, "
						+ " matricula, senha, rua, numero, bairro, cidade, "
						+ "cep, uf, contato_fk, tipo_pessoa) "
						+ "VALUES ("
						+ (i + 1)
						+ ", 'Felipe', 'Sobrenome', 'Masculino', '129336573922', "
						+ "'0394759', '54321', "
						+ "'31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b', "
						+ "'Rua do Pedagogo', 120, 'Centro', 'Monteiro', '12345-032', 'PB',"
						+ (contatos + 1) + ", 'PEDAGOGO');";
				stmt.executeUpdate(sql);

				contatos = r.nextInt(199);
				sql = "INSERT INTO tb_pessoa(id, primeiro_nome, segundo_nome, sexo, cpf, rg, "
						+ "matricula, senha, rua, numero, bairro, cidade, "
						+ "cep, uf, contato_fk, tipo_pessoa) "
						+ "VALUES ("
						+ (i + 2)
						+ ", 'ADMINISTRADOR', 'ADM', 'Masculino', '02938475647', "
						+ "'1928590', 'administrador',"
						+ "'31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b', "
						+ "'Rua do ADM', 100, 'Centro', 'Monteiro', '12345-032', 'PB',"
						+ (contatos + 1) + ", 'ADMIN');";
				stmt.executeUpdate(sql);

			}

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");

	}

}