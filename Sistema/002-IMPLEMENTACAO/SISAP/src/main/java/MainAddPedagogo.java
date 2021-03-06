import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class MainAddPedagogo {

	private static final Log LOGGER = LogFactory.getLog(MainAddPedagogo.class);

	public void createTables() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			Endereco endereco = new Endereco();
			endereco.setBairro("Prado");
			endereco.setCep("55200-000");
			endereco.setCidade("Pesqueira");
			endereco.setNumero(11);
			endereco.setRua("Rua Santa Agueda");
			endereco.setUf("PE");

			Pedagogo pedagogo = new Pedagogo();
			pedagogo.setMatriculaSuap("exemplo");
			pedagogo.setSexo("Masculino");
			pedagogo.setGrupo("PEDAGOGO");

			Pedagogo administrador = new Pedagogo();
			administrador.setPrimeiroNome("ADMINISTRADOR");
			administrador.setGrupo("ADMIN");
			administrador.setEndereco(endereco);
			administrador.setMatriculaSuap("administrador");
			administrador
					.setSenha("31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b");


			Contato contato = new Contato();
			contato.setEmail("exemplo@gmail.com");
			contato.setCelular("1234567890");
			
			Contato contato2 = new Contato();
			contato2.setEmail("exemplo@gmail.com");
			contato2.setCelular("1234567890");
			
			pedagogo.setPrimeiroNome("Exemplo");
			pedagogo.setSegundoNome("de Cadastro");
			pedagogo.setCpf("0000200001112");
			pedagogo.setEndereco(endereco);
			pedagogo.setSenha("31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b");

			contato2.setPessoa(administrador);
			administrador.setContato(contato2);
			
			contato.setPessoa(pedagogo);
			pedagogo.setContato(contato);

			
			
			em.persist(administrador);
			em.persist(pedagogo);

			// Chamada para adicionar alunos
			MainAddAluno.adicionaAlunos();

		} catch (RollbackException ex) {
			LOGGER.warn("FAIL to save new Pedagogo", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}

}
