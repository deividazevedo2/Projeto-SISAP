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
	 * Método para validar todos os campos do pedagogo. Caso algum campo não
	 * esteja de acordo com o esperado ou seja nulo e/ou vazio, este método
	 * retorna uma exceção SisapException com a mensagem de erro.
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
		if (!(pedagogo.getSexo().equals("FEMININO"))
				|| !(pedagogo.getSexo().equals("MASCULINO"))) {
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
				if (validarEmail(contato.getEmail())) {
					throw new SisapException(MSG_CAMPO_INVALIDO);
				}
			}
		}

	}

	/**
	 * Método para validar todos os campos do professor. Caso algum campo não
	 * esteja de acordo com o esperado ou seja nulo e/ou vazio, este método
	 * retorna uma exceção SisapException com a mensagem de erro.
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
	 * Método para verificar e validar um email digitado pelo usuário. É
	 * verificado utilizando um padrão inserido no Pattern. Caso não esteja de
	 * acordo com o padrão adotado o método retorna false.
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
	 * Algumas string precisam ter apenas números, como no caso da matrícula do
	 * SUAP. Este método verifica se tem apenas números na string ou se há algum
	 * caractere que não deve ser inserido (letras ou símbolos). Retorna um
	 * booleano true caso tenha apenas numeros ou false caso haja algum
	 * caractere inválido (letra ou símbolo).
	 * 
	 * @param verificar
	 * @return
	 */
	public boolean ehInteiro(String verificar) {
		// cria um array de char
		char[] c = verificar.toCharArray();
		boolean d = true;
		for (int i = 0; i < c.length; i++)
			// verifica se o char não é um dígito
			if (!Character.isDigit(c[i])) {
				d = false;
				break;
			}
		return d;
	}

}
