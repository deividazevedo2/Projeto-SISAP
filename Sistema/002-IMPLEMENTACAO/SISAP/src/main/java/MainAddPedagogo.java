import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainAddPedagogo {

	private static final Log LOGGER = LogFactory.getLog(MainAddPedagogo.class);

	private MainAddPedagogo() {
	}

	public static void main(String[] args) {

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
			pedagogo.setMatriculaSuap("felipe");
			pedagogo.setSexo("Masculino");
			Contato contato = new Contato();
			contato.setEmail("deividazevedo@gmail.com");
			contato.setCelular("1234567890");
			pedagogo.setPrimeiroNome("Widancassio");
			pedagogo.setSegundoNome("Galindo");
			pedagogo.setCpf("0000200001112");
			pedagogo.setEndereco(endereco);
			pedagogo.setSenha("31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b");

			contato.setPessoa(pedagogo);
			pedagogo.setContato(contato);

			em.persist(pedagogo);
		} catch (RollbackException ex) {
			LOGGER.warn("Erro ao salvar cadastro!", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}

}
