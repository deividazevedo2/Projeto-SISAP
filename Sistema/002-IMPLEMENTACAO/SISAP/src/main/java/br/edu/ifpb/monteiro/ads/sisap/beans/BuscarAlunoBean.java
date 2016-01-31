package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;

@Named
@ConversationScoped
public class BuscarAlunoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7928640369695996239L;

	Aluno aluno = new Aluno();

	private String matricula;

	@Inject
	private AlunoService alunoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void preRenderView() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	/**
	 * Metodo que captura a pessoa (Usuario do sistema) logado no momento.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public Aluno buscarAluno() throws SisapException {
		aluno = alunoService.buscarPorId(aluno.getId());

		return aluno;
	}

	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(matricula);

		return aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
