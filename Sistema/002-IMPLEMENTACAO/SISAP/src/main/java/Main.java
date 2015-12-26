import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class Main {
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
			pedagogo.setMatriculaSuap("65050265265206");
			pedagogo.setSexo("Masculino");
			Contato contato = new Contato();
			contato.setEmail("deividazevedo1@gmail.com");
			contato.setCelular("1234567890");
			pedagogo.setContato(contato);
			pedagogo.setPrimeiroNome("Widancassio");
			pedagogo.setSegundoNome("Galindo");
			pedagogo.setCpf("000020000115");
			pedagogo.setEndereco(endereco);
			pedagogo.setSenha("31b40d73c5430362a8be7c76e9f44492a256da37c98dd9f7c34b2ecebc88b68b");

			em.persist(pedagogo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		System.out.println("It is over");

	}

}
