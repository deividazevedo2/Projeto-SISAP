package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

@Named
@RequestScoped
public class PedagogoConverter implements Converter {

	@Inject
	private PedagogoDAO pedagogos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String valor) {
		if (valor == null || valor.trim().isEmpty()) {
			return null;
		}
		String matricula = String.valueOf(valor);

		try {
			return pedagogos.buscarPorMatricula(matricula);
		} catch (SisapException e) {
			String msgErroStr = String
					.format("Erro de conversao! Nao foi possivel realizar a conversao da string '%s' para o tipo esperado.",
							valor);
			FacesMessage msgErro = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

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
