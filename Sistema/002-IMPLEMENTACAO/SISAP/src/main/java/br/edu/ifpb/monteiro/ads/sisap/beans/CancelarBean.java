package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ConversationScoped
public class CancelarBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	public void cancelar() {
		addMessage("System Error", "Please try again later.");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}