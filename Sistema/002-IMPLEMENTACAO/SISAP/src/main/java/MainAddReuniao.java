import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;

public class MainAddReuniao {
	
	private static final Log LOGGER = LogFactory.getLog(MainAddAluno.class);
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SISAP");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			
			
//			//CRIANDO E ADICIONANDO UMA REUNIAO AO BANCO DE DADOS
			Reuniao reuniao = new Reuniao();
//			reuniao.setDataDeAgendamento("01/02/2016");
//			reuniao.setDataDeFinalizacao("02/02/2016");
//			reuniao.setDescricao("Reuniao descricao");
//			reuniao.setObjetivo("reuniao");
//			reuniao.setPauta("sdjkjdlfjsdlkjf");
//			reuniao.setSituacao("Maria");
//			reuniao.setSolicitante("xfdklfdjkflj");
//			
//			em.persist(reuniao);
			
//			Buscar Reuniao
			reuniao.setId(2);
			Reuniao r = em.merge(reuniao);
			System.out.println();
			

		}catch (Exception ex) {
			LOGGER.warn("Erro ao salvar reuniao!", ex);
		} finally {
			em.getTransaction().commit();
			emf.close();
		}

		LOGGER.info("It is Over");

	}

}
