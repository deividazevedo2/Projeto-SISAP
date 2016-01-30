package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Named
@ConversationScoped
public class DeletarPedagogoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8611704093255027657L;

	private static final Log LOGGER = LogFactory.getLog(DeletarPedagogoBean.class);

	private Pedagogo pedagogo;

	@Inject
//	@RequestScoped
	private PedagogoService pedagogoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	/**
	 * Metodo para realizar a exclusao do cadastro do pedagogo.
	 * 
	 * @return
	 */
	public String excluirPedagogo() {
		conversation.end();

		try {
			if ((pedagogo.getMatriculaSuap() == "0")
					&& pedagogo.getMatriculaSuap().isEmpty()) {

				pedagogoService.remover(pedagogo);
				reportarMensagemDeSucesso("Pedagogo removido com sucesso!");

			}
		} catch (RollbackException | SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			LOGGER.warn("Erro ao salvar cadastro!", exception);
			return null;
		}
		return EnderecoPaginas.REDIRECT_TRUE;
	}

	public String cancel() {
		conversation.end();
		return EnderecoPaginas.REDIRECT_TRUE;
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setAluno(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

}
