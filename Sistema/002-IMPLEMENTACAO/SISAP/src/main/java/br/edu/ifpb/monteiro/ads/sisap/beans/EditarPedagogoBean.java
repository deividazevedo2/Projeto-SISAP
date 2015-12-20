package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@ConversationScoped
public class EditarPedagogoBean extends ClasseAbstrata {

	private static final long serialVersionUID = 1L;

	private Pedagogo pedagogo;

	@Inject
	private PedagogoService pedagogoService;

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

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

	public String salvarPedagogo() throws SisapException {
		conversation.end();
		try {
			if (pedagogo.getMatriculaSuap() != null) {
				pedagogoService.atualizar(pedagogo);
				reportarMensagemDeSucesso("Usuário atualizado com sucesso!");
			} else {
				pedagogoService.salvar(pedagogo);
				reportarMensagemDeSucesso("Usuário criado com sucesso!");
			}
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
		}

		return EnderecoPaginas.REDIRECT_TRUE;
	}

}
