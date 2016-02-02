import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class MainAddAluno {

	private static final Log LOGGER = LogFactory.getLog(MainAddAluno.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			
			//CRIANDO E ADICIONANDO ALUNO 1 AO BANCO DE DADOS
			Contato c1 = new Contato();
			c1.setEmail("deividazeved@gmail.com");
			c1.setCelular("1234567890");

			Endereco e1 = new Endereco();
			e1.setBairro("Prado");
			e1.setCep("55200-000");
			e1.setCidade("Pesqueira");
			e1.setNumero(11);
			e1.setRua("Rua Santa Agueda");
			e1.setUf("PE");

			Aluno a1 = new Aluno();
			Responsavel r1 = new Responsavel();

			r1.setContato(c1);
			r1.setContato(c1);
			r1.setEndereco(e1);

			a1.setContato(c1);
			a1.setEndereco(e1);
			a1.setMae("mae");
			a1.setMatricula("123");
			a1.setPai("aijsiasjisa");

			r1.setAluno(a1);
			a1.setResponsavel(r1);
			em.persist(a1);
			
			
			//CRIANDO E ADICIONANDO ALUNO 2 AO BANCO DE DADOS
			Contato c2 = new Contato();
			c2.setEmail("aluno2@gmail.com");
			c2.setCelular("192827382711");

			Endereco e2 = new Endereco();
			e2.setBairro("Centro");
			e2.setCep("56600-000");
			e2.setCidade("sertania");
			e2.setNumero(190);
			e2.setRua("Rua Afonso Bezerra");
			e2.setUf("PE");

			Aluno a2 = new Aluno();
			Responsavel r2 = new Responsavel();

			r2.setContato(c2);
			r2.setContato(c2);
			r2.setEndereco(e2);

			a2.setContato(c2);
			a2.setEndereco(e2);
			a2.setMae("Mae 2");
			a2.setMatricula("999");
			a2.setPai("Pai 2");

			r2.setAluno(a2);
			a2.setResponsavel(r2);
			em.persist(a2);
			
			
			//CRIANDO E ADICIONANDO ALUNO 3 AO BANCO DE DADOS
			Contato c3 = new Contato();
			c3.setEmail("aluno3@hotmail.com");
			c3.setCelular("192822910091");

			Endereco e3 = new Endereco();
			e3.setBairro("Varzea");
			e3.setCep("53282-180");
			e3.setCidade("Tabira");
			e3.setNumero(203);
			e3.setRua("Rua Maria Joaquina");
			e3.setUf("PB");

			Aluno a3 = new Aluno();
			Responsavel r3 = new Responsavel();

			r3.setContato(c3);
			r3.setContato(c3);
			r3.setEndereco(e3);

			a3.setContato(c3);
			a3.setEndereco(e3);
			a3.setMae("Mae do Aluno 3");
			a3.setMatricula("76483");
			a3.setPai("Joao Paulo");

			r3.setAluno(a3);
			a3.setResponsavel(r3);
			em.persist(a3);

		} catch (Exception ex) {
			LOGGER.warn("Erro ao salvar cadastro!", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}

}
