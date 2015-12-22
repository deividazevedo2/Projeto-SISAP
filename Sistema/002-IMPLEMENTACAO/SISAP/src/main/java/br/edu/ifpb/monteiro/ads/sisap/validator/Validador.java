package br.edu.ifpb.monteiro.ads.sisap.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

public class Validador {

	private final String MSG_CAMPO_INVALIDO = "Verifique os campos e tente novamente";
	private final String PATTERN_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$";

	/**
	 * Metodo para validar todos os campos do pedagogo. Caso algum campo nao
	 * esteja de acordo com o esperado ou seja nulo e/ou vazio, este metodo
	 * retorna uma excecao com uma mesagem de erro.
	 * 
	 * @param pedagogo
	 * @throws SisapException
	 */
	public void ValidarCamposPedagogo(Pedagogo pedagogo) throws SisapException {
		if (pedagogo.getPrimeiroNome().equals("")
				|| pedagogo.getPrimeiroNome().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getSegundoNome().equals("")
				|| pedagogo.getSegundoNome().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getSexo().equals("") || pedagogo.getSexo().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(pedagogo.getSexo().toUpperCase().equals("FEMININO"))
				&& !(pedagogo.getSexo().toUpperCase().equals("MASCULINO"))) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getDataNascimento().equals("")
				|| pedagogo.getDataNascimento().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getMatriculaSuap().equals("")
				|| pedagogo.getMatriculaSuap().equals(null)
				|| !(ehInteiro(pedagogo.getMatriculaSuap()))) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getNaturalidade().equals("")
				|| pedagogo.getNaturalidade().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getEndereco().equals(null)
				|| pedagogo.getEndereco().equals("")) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(pedagogo.getCpf().length() == 14) || pedagogo.getCpf().equals("")
				|| pedagogo.getCpf().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getRg().equals("") || pedagogo.getRg().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (pedagogo.getContatos().isEmpty()) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(pedagogo.getContatos().isEmpty())) {
			List<Contato> contatos = pedagogo.getContatos();
			for (Contato contato : contatos) {
				if (!validarEmail(contato.getEmail())) {
					throw new SisapException(MSG_CAMPO_INVALIDO);
				}
			}
		}

	}

	/**
	 * Metodo para validar todos os campos de professor. Caso algum campo nao
	 * esteja de acordo com o esperado ou seja nulo e/ou vazio, este metodo
	 * retorna uma excecao com uma mesagem de erro.
	 * 
	 * @param profesor
	 * @throws SisapException
	 */
	public void ValidarCamposProfessor(Professor profesor)
			throws SisapException {
		if (profesor.getPrimeiroNome().equals("")
				|| profesor.getPrimeiroNome().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getSegundoNome().equals("")
				|| profesor.getSegundoNome().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getSexo().equals("") || profesor.getSexo().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(profesor.getSexo().equals("FEMININO"))
				|| !(profesor.getSexo().equals("MASCULINO"))) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getDataNascimento().equals("")
				|| profesor.getDataNascimento().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getMatriculaSuap().equals("")
				|| profesor.getMatriculaSuap().equals(null)
				|| !(ehInteiro(profesor.getMatriculaSuap()))) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getNaturalidade().equals("")
				|| profesor.getNaturalidade().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getEndereco().equals(null)
				|| profesor.getEndereco().equals("")) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(profesor.getCpf().length() == 14) || profesor.getCpf().equals("")
				|| profesor.getCpf().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getRg().equals("") || profesor.getRg().equals(null)) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (profesor.getContatos().isEmpty()) {
			throw new SisapException(MSG_CAMPO_INVALIDO);
		}
		if (!(profesor.getContatos().isEmpty())) {
			List<Contato> contatos = profesor.getContatos();
			for (Contato contato : contatos) {
				if (validarEmail(contato.getEmail())) {
					throw new SisapException(MSG_CAMPO_INVALIDO);
				}
			}
		}

	}

	/**
	 * 
	 * Metodo para verificar e validar um email digitado pelo usuario. Eh
	 * verificado utilizando um padrao inserido no Pattern. caso nao esteja de
	 * acordo com o padrao adotado o metodo retorna false.
	 * 
	 * @param email
	 * @return
	 */
	private boolean validarEmail(String email) {
		Pattern p = Pattern.compile(PATTERN_EMAIL);
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Algumas strings precisam ter apenas numeros, como no caso da matricula do
	 * SUAP. Este metodo verifica se tem apenas numeros na string ou se ha algum
	 * caractere que nao deve ser inserido(letras ou simbolos). Retorna um
	 * booleano true caso tenha apenas numeros ou false caso haja caractere
	 * invalido.
	 * 
	 * @param verificar
	 * @return
	 */
	public boolean ehInteiro(String verificar) {
		// cria um array de char
		char[] c = verificar.toCharArray();
		boolean d = true;
		for (int i = 0; i < c.length; i++)
			// verifica se o char nao eh um digito
			if (!Character.isDigit(c[i])) {
				d = false;
				break;
			}
		return d;
	}

}
