package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
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
public class EditarPedagogoBean extends ClasseAbstrata implements BeanIF<Pedagogo>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Pedagogo pedagogo;

	@Inject
	private	ServiceIF<Pedagogo> pedagogoService;
	
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

	@Override
	public String salvar() throws SisapException {
		conversation.end();
		try {
			if((pedagogo.getMatriculaSuap() != null) && (pedagogo.getId() != null) && (pedagogo.getSenha() != null)){
				pedagogoService.atualizar(pedagogo);
				reportarMensagemDeSucesso("Pedagogo" + pedagogo.getPrimeiroNome()+" atualizao com sucesso.");
			} else {
				pedagogoService.salvar(pedagogo);
				reportarMensagemDeSucesso("Pedagogo " + pedagogo.getPrimeiroNome()
						+ " salvo com sucesso!");
			}
		} catch (SisapException exception) {
			reportarMensagemDeErro(exception.getMessage());
			return null;
		}

		return EnderecoPaginas.PAGINA_PRINCIPAL_PEDAGOGO;
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
