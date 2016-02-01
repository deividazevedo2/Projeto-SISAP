package br.edu.ifpb.monteiro.ads.sisap.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.dao.AlunoDAO;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;

@Named
@RequestScoped
public class AlunoConverter implements Converter {

	@Inject
	private AlunoDAO alunos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String matricula) {
		if (matricula == null || matricula.trim().isEmpty()) {
			return null;
		}

		try {
			return alunos.buscarPorMatricula(matricula);
		} catch (SisapException e) {
			String msgErroStr = String
					.format("Erro de conversão!",
							matricula);

			@SuppressWarnings("unused")
			FacesMessage msgErro = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);

			throw new RuntimeException(e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object valor) {
		if (valor == null) {
			return null;
		}
		String matriculaAluno = ((Aluno) valor).getMatricula();

		return (matriculaAluno != null) ? matriculaAluno.toString() : null;
	}

}
