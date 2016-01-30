import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Responsavel;

public class MainNovo {

	private static final Log LOGGER = LogFactory.getLog(MainNovo.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			Contato contato = new Contato();
			contato.setEmail("deividazeved@gmail.com");
			contato.setCelular("1234567890");

			Endereco endereco = new Endereco();
			endereco.setBairro("Prado");
			endereco.setCep("55200-000");
			endereco.setCidade("Pesqueira");
			endereco.setNumero(11);
			endereco.setRua("Rua Santa Agueda");
			endereco.setUf("PE");

			Aluno aluno = new Aluno();
			Responsavel resp = new Responsavel();

			resp.setContato(contato);
			resp.setContato(contato);
			resp.setEndereco(endereco);

			aluno.setContato(contato);
			aluno.setEndereco(endereco);
			aluno.setMae("mae");
			aluno.setMatricula(Long.parseLong("123"));
			aluno.setPai("aijsiasjisa");

			resp.setAluno(aluno);
			aluno.setResponsavel(resp);
			em.persist(aluno);

		} catch (Exception ex) {
			LOGGER.warn("Erro ao salvar cadastro!", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}

}
