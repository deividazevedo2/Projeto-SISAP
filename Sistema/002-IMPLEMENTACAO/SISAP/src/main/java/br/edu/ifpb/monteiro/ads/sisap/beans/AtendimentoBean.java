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
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;
import br.edu.ifpb.monteiro.ads.sisap.service.AtendimentoService;
import br.edu.ifpb.monteiro.ads.sisap.service.AtividadeService;

@Named
@ConversationScoped
public class AtendimentoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory.getLog(AtendimentoBean.class);

	private List<Atendimento> atendimentos;

	private Aluno aluno;

	private Atendimento atendimento = new Atendimento();

	String matriculaAluno;
	String nomeAluno;

	@Inject
	private AlunoService alunoService;

	@Inject
	private AtividadeService atividadeService;

	@Inject
	private AtendimentoService atendimentoService;

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
		if (atendimento == null) {
			atendimento = new Atendimento();
		}
		if (atendimentos == null) {
			atendimentos = new ArrayList<Atendimento>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(aluno.getMatricula());

		return aluno;
	}

	public String salvarAtendimento() throws SisapException {
		if (atendimento.getMatriculaAluno() == null) {
			atendimento.setNomeAluno(nomeAluno);
			atendimento.setMatriculaAluno(matriculaAluno);
		}
		if (atendimento.getSolicitante() == null
				|| "".equals(atendimento.getSolicitante())) {
			atendimento.setSolicitante("Nao ha");
		}
		if (atendimento.getId() != null) {
			atividadeService.atualizar(atendimento);
		} else {
			atividadeService.salvar(atendimento);
		}
		reportarMensagemDeSucesso("Atendimento realizado com sucesso!");
		return EnderecoPaginas.PAGINA_PRINCIPAL_ATENDIMENTOS;

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
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
			atendimentos = atendimentoService.getAll(matriculaAluno, nomeAluno);
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
		// atendimento.setAluno(aluno);
		// setAtendimento(atendimento);
	}

}
