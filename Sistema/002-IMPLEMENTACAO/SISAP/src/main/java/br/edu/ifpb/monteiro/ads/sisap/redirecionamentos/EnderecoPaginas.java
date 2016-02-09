package br.edu.ifpb.monteiro.ads.sisap.redirecionamentos;

/**
 * Caminho das paginas para realizar o redirecionamento no bean.
 * 
 * @author Deivid Azevedo
 *
 */
public class EnderecoPaginas {

	private EnderecoPaginas() {
	}

	public static final String REDIRECT_TRUE = "?faces-redirect=true";

	public static final String PAGINA_PRINCIPAL_LOGIN = "/paginas/login"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_PEDAGOGO = "/paginas/pedagogo/indexPedagogo"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_ADMIN = "/paginas/admin/indexAdmin"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_ATENDIMENTOS = "/paginas/pedagogo/listarAtendimentos"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_REUNIOES = "/paginas/pedagogo/listarReunioes"
			+ REDIRECT_TRUE;

	public static final String PAGINA_PRINCIPAL_VISITAS = "/paginas/pedagogo/listarVisitasDomiciliares"
			+ REDIRECT_TRUE;
}
