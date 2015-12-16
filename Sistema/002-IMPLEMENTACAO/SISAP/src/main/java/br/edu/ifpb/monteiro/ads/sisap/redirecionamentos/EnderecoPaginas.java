package br.edu.ifpb.monteiro.ads.sisap.redirecionamentos;

public class EnderecoPaginas {

	private static final String REDIRECT_TRUE = "?faces-redirect=true";

	public static final String PAGINA_PRINCIPAL_LOGIN = "/paginas/login"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_PEDAGOGO = "/paginas/indexPedagogo"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_PROFESSOR = "/paginas/indexProfessor"
			+ REDIRECT_TRUE;
}
