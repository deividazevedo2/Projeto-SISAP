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

		MainAddPedagogo adicionaDados = new MainAddPedagogo();

		// É criado o cadastro de um pedagogo e um administrador. Após isso os
		// dados de um aluno também são populados no banco de dados desta
		// aplicação.
		adicionaDados.createTables();

	}

}
