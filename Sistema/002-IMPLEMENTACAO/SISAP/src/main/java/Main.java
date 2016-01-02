import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {

	private static final Log LOGGER = LogFactory.getLog(Main.class);

	private Main() {
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
			pedagogo.setMatriculaSuap("65050265265200");
			pedagogo.setSexo("Masculino");
			Contato contato = new Contato();
			contato.setEmail("deividazevedo1@gmail.com");
			contato.setCelular("1234567890");
			pedagogo.setPrimeiroNome("Widancassio");
			pedagogo.setSegundoNome("Galindo");
			pedagogo.setCpf("000020000110");
			pedagogo.setEndereco(endereco);
			pedagogo.setSenha("pedagogo");

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
