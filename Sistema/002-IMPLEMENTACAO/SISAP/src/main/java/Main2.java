import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.dao.AlunoDAO;
import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Aula;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;

public class Main2 {

	private static final Log LOGGER = LogFactory.getLog(Main2.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {

			Aula aula = new Aula();
			aula.setConteudo("Matematica Aplicada");
			Date data = new Date();
			data.setDate(12);
			data.setMonth(2);
			data.setYear(2012);
			aula.setData(data);
			AlunoDAO alunoDAO = new AlunoDAO();

			Aluno aluno = alunoDAO.buscarPorId(1);
			aula.setAluno(aluno);

			// PedagogoDAO pedagogoDAO = new PedagogoDAO();

			// Pedagogo pedagogo = pedagogoDAO
			// .buscarPorMatricula("65050265265200");

			// System.out.println(pedagogo.getPrimeiroNome());

			em.persist(aula);

		} catch (Exception ex) {
			LOGGER.warn("Erro ao salvar cadastro!", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}
}
