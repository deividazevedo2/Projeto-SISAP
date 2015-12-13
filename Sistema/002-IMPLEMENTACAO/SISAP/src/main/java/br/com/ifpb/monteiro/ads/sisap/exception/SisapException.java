package br.com.ifpb.monteiro.ads.sisap.exception;

public class SisapException extends Exception {

	private static final long serialVersionUID = -5426566422361229699L;

	public SisapException(String mensagem) {
		super(mensagem);
	}
	
	public SisapException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
