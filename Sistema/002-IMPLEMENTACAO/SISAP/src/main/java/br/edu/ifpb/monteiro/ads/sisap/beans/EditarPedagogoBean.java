package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@ConversationScoped
public class EditarPedagogoBean extends ClasseAbstrata{
	
	private static final long serialVersionUID = -79727005056917194L;

	@Inject
	private Pedagogo pedagogo;
	
	@Inject
	private	PedagogoService pedagogoService;
	
	@Inject
	private Conversation conversation;
	
	
	public void preRenderView() {
		if (pedagogo == null) {
			pedagogo = new Pedagogo();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String salvarPedagogo() {
		conversation.end();
		try {
			if((pedagogo.getMatriculaSuap() != null) && (pedagogo.getId() != null) && (pedagogo.getConta().getLogin() != null)){
				pedagogoService.editarPedagogo(pedagogo);
				reportarMensagemDeSucesso("Pedagogo" + pedagogo.getPrimeiroNome()+" atualizao com sucesso.");
			} else {
				pedagogoService.addPedagogo(pedagogo);
				reportarMensagemDeSucesso("Pedagogo " + pedagogo.getPrimeiroNome()
						+ " salvo com sucesso!");
			}
		} catch (SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			return null;
		}

		return EnderecoPaginas.PAGINA_PRINCIPAL_USUARIOS;
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

	
}
