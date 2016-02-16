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
import br.edu.ifpb.monteiro.ads.sisap.service.AtividadeService;
import br.edu.ifpb.monteiro.ads.sisap.service.VisitaDomiciliarService;

/**
 * Classe que recebe dados do XHTML e realiza as operações necessárias,
 * retornando para a tela aquilo que o usuário necessita/solicita no momento.
 * 
 * @author Deivid, Indy, Widancássio
 *
 */
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
	private AtividadeService atividadeService;

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

	/**
	 * Método para realizar a busca do aluno pela matrícula do mesmo.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(aluno.getMatricula());

		return aluno;
	}

	/**
	 * Metodo para salvar uma nova visita domiciliar caso o ID dela seja nulo.
	 * Também serve para realizar a alteração de dados de uma visita
	 * anteriormente salva, onde é verificado se a atividade possui ID válido,
	 * onde realizará as alterações das informações e salvará de volta no
	 * banco.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public String salvarVisitaDomiciliar() throws SisapException {

		visitaDomiciliar.setTipoAtividade("Visita Domiciliar");

		if (visitaDomiciliar.getMatriculaAluno() == null) {
			visitaDomiciliar.setNomeAluno(alunoService.buscarPorMatricula(
					matriculaAluno).getNome());
			visitaDomiciliar.setMatriculaAluno(matriculaAluno);
		}
		if (visitaDomiciliar.getId() != null) {
			atividadeService.atualizar(visitaDomiciliar);
		} else {
			atividadeService.salvar(visitaDomiciliar);
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

	public List<VisitaDomiciliar> getVisitasDomiciliares() {
		return visitasDomiciliares;
	}

	public void setVisitasDomiciliares(
			List<VisitaDomiciliar> visitasDomiciliares) {
		this.visitasDomiciliares = visitasDomiciliares;
	}

	/**
	 * Método para realizar a filtragem das visitas domiciliares feitas pelo
	 * usuário (pedagogo). Pode-se inclusive, adicionar a matricula e o nome do
	 * aluno para uma busca mais refinada de dados.
	 */
	public void filtrar() {
		try {
			visitasDomiciliares = visitaDomiciliarService.getAll(
					matriculaAluno, nomeAluno);
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
	}

	/**
	 * Limpar os campos de matricula do aluno e nome do mesmo.
	 */
	public void limpar() {
		matriculaAluno = null;
		nomeAluno = null;
	}

	/**
	 * Abre a POP-UP de diálogo para que o usuário informe qual o aluno que
	 * deseja realizar a visita domiciliar.
	 */
	public void abrirDialogoAluno() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog("listaAlunos", opcoes,
				null);

	}

	/**
	 * Aluno selecionado a partir da POP-UP exibida na tela.
	 * 
	 * @param aluno
	 */
	public void selecionarAluno(Aluno aluno) {
		RequestContext.getCurrentInstance().closeDialog(aluno);
	}

	/**
	 * Captura o aluno selecionado e insere a matricula e nome em atributos
	 * criados nesta classe.
	 * 
	 * @param event
	 */
	public void alunoSelecionado(SelectEvent event) {
		aluno = (Aluno) event.getObject();
		matriculaAluno = aluno.getMatricula();
		nomeAluno = aluno.getNome();
	}

}
