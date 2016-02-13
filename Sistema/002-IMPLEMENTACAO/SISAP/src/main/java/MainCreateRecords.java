
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

		// Chama primeiro o Main Pedagogo para criar as tabelas e o cadastro de
		// um pedagogo como exemplo.
		adicionaDados.createTables();

	}

}
