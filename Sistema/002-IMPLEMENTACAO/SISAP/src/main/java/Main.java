import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

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
			pedagogo.setPrimeiroNome("Widancassio");
			pedagogo.setSegundoNome("Galindo");
			pedagogo.setCpf("000020000115");
			pedagogo.setEndereco(endereco);
			pedagogo.setSenha("pedagogo");

			// em.persist(pedagogo);
			// Pedagogo p = em.find(Pedagogo.class,
			// Long.parseLong("65050265265206"));
			// System.out.println(p.getPrimeiroNome());

			Long matriculaPedagogo = Long.parseLong("65050265265206");
			Pedagogo resultado = null;
			if (matriculaPedagogo == null) {
				matriculaPedagogo = Long.valueOf("");
			}
			try {
				TypedQuery<Pedagogo> query = em
						.createQuery(
								"select ps from Pessoa ps where ps.matriculaSuap like :matriculaSuap",
								Pedagogo.class);
				query.setParameter("matriculaSuap", matriculaPedagogo);
				resultado = query.getSingleResult();
			} catch (PersistenceException pe) {
				throw new SisapException(
						"Erro ao recuperar o pedagogo pela matricula.", pe);
			}
			System.out.println(resultado.getPrimeiroNome());

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		System.out.println("It is over");

	}

}
