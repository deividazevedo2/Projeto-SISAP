package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.DiarioDeAtividadesService;

@Named
@ConversationScoped
public class DiarioDeAtividadesBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory
			.getLog(DiarioDeAtividadesBean.class);

	private List<Object> atividadesDoPedagogo;

	private Object atividade = new Object();

	@Inject
	private DiarioDeAtividadesService atividadesDoPedagogoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		filtrar();
	}

	public void preRenderView() {
		if (atividade == null) {
			atividade = new Object();
		}
		if (atividadesDoPedagogo == null) {
			atividadesDoPedagogo = new ArrayList<Object>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Object> getAtividadesDoPedagogo() {
		return atividadesDoPedagogo;
	}

	public void setAtividadesDoPedagogo(List<Object> atividadesDoPedagogo) {
		this.atividadesDoPedagogo = atividadesDoPedagogo;
	}

	public void filtrar() {
		try {
			atividadesDoPedagogo = atividadesDoPedagogoService.getAll();
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
	}

	public Object getAtividade() {
		return atividade;
	}

	public void setAtividade(Object atividade) {
		this.atividade = atividade;
	}

}
