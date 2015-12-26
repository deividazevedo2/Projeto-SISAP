package br.edu.ifpb.monteiro.ads.sisap.exception;

/**
 * Classe SisapException para lancamento de excecoes do sistema SISAP.
 * 
 * @author Indy Paula
 *
 */
public class SisapException extends Exception {

	private static final long serialVersionUID = -5426566422361229699L;

	/**
	 * Mensagens de excecoes serao lancadas com este metodo.
	 * 
	 * @param mensagem
	 */
	public SisapException(String mensagem) {
		super(mensagem);
	}

	public SisapException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
