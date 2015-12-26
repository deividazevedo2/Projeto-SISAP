package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 * Classe para implementar as mensagens de sucesso e/ou erro que acontecerem
 * durante a interacao do usuario com o sistema.
 * 
 * @author Deivid Azevedo
 *
 */
public class ClasseAbstrata implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5350743353241300596L;

	/**
	 * Uma mensagem de erro eh mostrada na tela informando o erro acontecido.
	 * 
	 * @param detalhe
	 */
	protected void reportarMensagemDeErro(String detalhe) {
		reportarMensagem(true, detalhe);

	}

	/**
	 * Metodo para reportar uma mensagem de sucesso para o usuario. A mensagem
	 * eh passada como parametro neste metodo.
	 * 
	 * @param detalhe
	 */
	protected void reportarMensagemDeSucesso(String detalhe) {
		reportarMensagem(false, detalhe);
	}

	/**
	 * Metodo para repostar uma mensagem que pode ser do tipo sucesso ou erro.
	 * Esse tipo eh informado no atributo do metodo isErro o qual eh um boleano
	 * true ou false.
	 * 
	 * @param isErro
	 * @param detalhe
	 */
	protected void reportarMensagem(boolean isErro, String detalhe) {
		String tipo = "Sucesso!";
		Severity severity = FacesMessage.SEVERITY_INFO;
		if (isErro) {
			tipo = "Erro!";
			severity = FacesMessage.SEVERITY_ERROR;
			FacesContext.getCurrentInstance().validationFailed();
		}

		FacesMessage msg = new FacesMessage(severity, tipo, detalhe);

		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.setKeepMessages(false);
		flash.setRedirect(true);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

}
