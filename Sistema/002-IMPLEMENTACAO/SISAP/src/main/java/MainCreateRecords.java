import br.edu.ifpb.monteiro.ads.sisap.dao.PostgreSQLJDBC;

/**
 * Main principal, é ele quem deve ser executado, apenas.. Lembrar de limpar o
 * banco sempre que for preciso executar esta classe, pois senão não irá criar
 * os dados novamente, visto que todos os dados estarão duplicados.
 * 
 * @author DVD
 *
 */
public class MainCreateRecords {

	public static void main(String[] args) {

		PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
		MainAddPedagogo mainAddPedagogo = new MainAddPedagogo();

		// Chama primeiro o Main Pedagogo para criar as tabelas e o cadastro de
		// um pedagogo como exemplo.
		mainAddPedagogo.createTables();

		// Chama a classe onde TODAS as informações são persistidas nas
		// respectivas tabelas no banco.
		// IMPORTANTE: só dá pra adicionar estas informações depois que as
		// tabelas tiverem sido criadas (por isso é feita a chamada anterior do
		// MainAddPedagogo).
		postgreSQLJDBC.generateData();

	}

}
