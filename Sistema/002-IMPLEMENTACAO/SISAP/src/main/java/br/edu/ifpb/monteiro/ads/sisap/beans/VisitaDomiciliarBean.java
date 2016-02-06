package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.VisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;
import br.edu.ifpb.monteiro.ads.sisap.service.VisitaDomiciliarService;

@Named
@ConversationScoped
public class VisitaDomiciliarBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory
			.getLog(VisitaDomiciliarBean.class);

	private List<VisitaDomiciliar> visitasDomiciliares;

	private Aluno aluno;

	private VisitaDomiciliar visitaDomiciliar = new VisitaDomiciliar();

	String matriculaAluno;
	String nomeAluno;

	@Inject
	private AlunoService alunoService;

	@Inject
	private VisitaDomiciliarService visitaDomiciliarService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		filtrar();
	}

	public void preRenderView() {
		if (aluno == null) {
			aluno = new Aluno();
		}
		if (visitaDomiciliar == null) {
			visitaDomiciliar = new VisitaDomiciliar();
		}
		if (visitasDomiciliares == null) {
			visitasDomiciliares = new ArrayList<VisitaDomiciliar>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<VisitaDomiciliar> getVisitasDomiciliares() {
		return visitasDomiciliares;
	}

	public void setVisitasDomiciliares(
			List<VisitaDomiciliar> visitasDomiciliares) {
		this.visitasDomiciliares = visitasDomiciliares;
	}

	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(aluno.getMatricula());

		return aluno;
	}

	public String salvarVisitaDomiciliar() throws SisapException {
		if (visitaDomiciliar.getMatriculaAluno() == null) {
			visitaDomiciliar.setNomeAluno(nomeAluno);
			visitaDomiciliar.setMatriculaAluno(matriculaAluno);
		}
		if (visitaDomiciliar.getId() != null) {
			visitaDomiciliarService.atualizar(visitaDomiciliar);
		} else {
			visitaDomiciliarService.salvar(visitaDomiciliar);
		}
		reportarMensagemDeSucesso("Visita Domiciliar registrada com sucesso!");
		return EnderecoPaginas.PAGINA_PRINCIPAL_VISITAS;

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public VisitaDomiciliar getVisitaDomiciliar() {
		return visitaDomiciliar;
	}

	public void setVisitaDomiciliar(VisitaDomiciliar visitaDomiciliar) {
		this.visitaDomiciliar = visitaDomiciliar;
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
			visitasDomiciliares = visitaDomiciliarService.getAll(
					matriculaAluno, nomeAluno);
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
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
	}

}
