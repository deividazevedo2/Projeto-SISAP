package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;

@Named
@SessionScoped
public class VisualizarBoletimBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory
			.getLog(VisualizarBoletimBean.class);

	private Aluno aluno = new Aluno();
	String matriculaAluno;
	String nomeAluno;

	@Inject
	private AlunoService alunoService;

	@Inject
	private Conversation conversation;

	public void init() {
		filtrar();
	}

	@PostConstruct
	public void preRenderView() {
		if (aluno == null) {
			aluno = new Aluno();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(aluno.getMatricula());

		return aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
	}

	public void limpar() {
		matriculaAluno = null;
		nomeAluno = null;
	}

	public void abrirDialogoAluno() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog("listaAlunos", opcoes,
				null);

	}

	public void selecionarAluno(Aluno aluno) {
		RequestContext.getCurrentInstance().closeDialog(aluno);
	}

	public void alunoSelecionado(SelectEvent event) {
		aluno = (Aluno) event.getObject();
		matriculaAluno = aluno.getMatricula();
		nomeAluno = aluno.getNome();
		// atendimento.setAluno(aluno);
		// setAtendimento(atendimento);
	}

}
