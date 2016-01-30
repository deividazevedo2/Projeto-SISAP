package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

/**
 * Esta classe representa o conversor de Pedagogo, cujo objetivo é converter um
 * valor enviando pela View em objeto ou retornar o ID do objeto. Ao implementar
 * a interface Converter dois métodos são implementados, getAsObject e
 * getAsString.
 * 
 * @author Deivid Azevedo
 *
 */
@Named
@RequestScoped
public class PedagogoConverter implements Converter {

	private static final Log LOGGER = LogFactory
			.getLog(PedagogoConverter.class);

	@Inject
	private PedagogoDAO pedagogos;

	/**
	 * Este método recebe a String e devolve o Object. Quando um Pedagogo for
	 * mostrado na tela será seu ID que estará sendo exibido.
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String valor) {
		if (valor == null || valor.trim().isEmpty()) {
			return null;
		}
		String matricula = String.valueOf(valor);

		try {
			return pedagogos.buscarPorMatricula((matricula));
		} catch (SisapException e) {
			String msgErroStr = String
					.format("Erro de conversao! Nao foi possivel realizar a conversao da string '%s' para o tipo esperado.",
							valor);
			FacesMessage msgErro = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			LOGGER.warn(msgErro, e);
		}
		return null;
	}

	/**
	 * Este método recebe o Object e devolve a String. Apartir dessa String
	 * recuperamos o Object que esta ligado ao modelo.
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object valor) {
		if (valor == null) {
			return null;
		}
		String cpfPedagogo = ((Pedagogo) valor).getCpf();

		return (cpfPedagogo != null) ? cpfPedagogo.toString() : null;
	}

}
