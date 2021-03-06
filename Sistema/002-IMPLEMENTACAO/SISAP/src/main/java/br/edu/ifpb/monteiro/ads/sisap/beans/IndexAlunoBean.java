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

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;

@Named
@ConversationScoped
public class IndexAlunoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory.getLog(IndexAlunoBean.class);

	private List<Aluno> alunos = new ArrayList<Aluno>();

	@Inject
	private AlunoService alunoService;

	private String matriculaAluno;
	private String nomeAluno;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		filtrar();
	}

	public void preRenderView() {
		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public void filtrar() {
		try {
			alunos = alunoService.getAll(matriculaAluno, nomeAluno);
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
	}

	public void limpar() {
		nomeAluno = null;
		matriculaAluno = null;
	}

}
