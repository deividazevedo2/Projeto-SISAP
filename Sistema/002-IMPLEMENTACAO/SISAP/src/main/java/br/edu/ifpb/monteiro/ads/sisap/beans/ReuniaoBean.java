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

import br.edu.ifpb.monteiro.ads.sisap.entities.Reuniao;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.AtividadeService;
import br.edu.ifpb.monteiro.ads.sisap.service.ReuniaoService;

@Named
@ConversationScoped
public class ReuniaoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory.getLog(ReuniaoBean.class);

	private List<Reuniao> reunioes;

	private Reuniao reuniao = new Reuniao();

	@Inject
	private ReuniaoService reuniaoService;

	@Inject
	private AtividadeService atividadeService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		filtrar();
	}

	public void preRenderView() {
		if (reuniao == null) {
			reuniao = new Reuniao();
		}
		if (reunioes == null) {
			reunioes = new ArrayList<Reuniao>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Reuniao> getReunioes() {
		return reunioes;
	}

	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}

	public String salvarReuniao() throws SisapException {

		if (reuniao.getId() != null) {
			atividadeService.atualizar(reuniao);
		} else {
			atividadeService.salvar(reuniao);
		}
		reportarMensagemDeSucesso("Reunião realizado com sucesso!");
		return EnderecoPaginas.PAGINA_PRINCIPAL_REUNIOES;

	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public void filtrar() {
		try {
			reunioes = reuniaoService.getAll();
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
	}

	public void limpar() {
	}

}
