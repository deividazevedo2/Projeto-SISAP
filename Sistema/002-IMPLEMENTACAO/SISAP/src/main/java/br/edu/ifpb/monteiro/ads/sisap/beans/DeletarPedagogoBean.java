package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.interfaces.BeanIF;
import br.edu.ifpb.monteiro.ads.sisap.interfaces.ServiceIF;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@ConversationScoped
public class DeletarPedagogoBean extends ClasseAbstrata implements BeanIF<Pedagogo> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pedagogo pedagogo;

	@Inject
	@RequestScoped
	private ServiceIF<Pedagogo> pedagogoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public String excluirPedagogo() {
		conversation.end();

		try {
			if ((pedagogo.getMatriculaSuap() == "0")
					&& pedagogo.getMatriculaSuap().isEmpty()) {
				pedagogoService.remover(pedagogo);
				reportarMensagemDeSucesso("Pedagogo removido com sucesso!");

			}
		} catch (SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			return null;
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL_PEDAGOGO;
	}

	public String cancel() {
		conversation.end();
		return EnderecoPaginas.PAGINA_PRINCIPAL_PEDAGOGO;
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setAluno(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

	@Override
	public String salvar() throws SisapException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar() throws SisapException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Pedagogo identificavel) throws SisapException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedagogo consultarPorId(Long id) throws SisapException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
