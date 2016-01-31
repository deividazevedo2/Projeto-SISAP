package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.dao.AtendimentoDAO;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

@Named
@RequestScoped
public class AtendimentoConverter implements Converter {

	@Inject
	private AtendimentoDAO atendimentos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String matricula) {
		if (matricula == null || matricula.trim().isEmpty()) {
			return null;
		}

		Integer id = Integer.parseInt(matricula);
		
		try {
			return atendimentos.buscarPorId(id);
		} catch (SisapException e) {
			String msgErroStr = String
					.format("Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
							matricula);
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
		Integer matriculaAluno = ((Atendimento) valor).getId();

		return (matriculaAluno != null) ? matriculaAluno.toString() : null;
	}

}
