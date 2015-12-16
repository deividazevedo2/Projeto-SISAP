package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@ConversationScoped
public class DeletarPedagogoBean extends ClasseAbstrata {

	private static final long serialVersionUID = 7500123259489897695L;

	private Pedagogo pedagogo;

	@Inject
	@RequestScoped
	private PedagogoService pedagogoService;

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
				pedagogoService.excluirPedagogo(pedagogo);
				reportarMensagemDeSucesso("Pedagogo removido com sucesso!");

			}
		} catch (SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			return null;
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL_USUARIOS;
	}

	public String cancel() {
		conversation.end();
		return EnderecoPaginas.PAGINA_PRINCIPAL_USUARIOS;
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setAluno(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}
	
}
