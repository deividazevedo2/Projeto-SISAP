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

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Bimestre;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;
import br.edu.ifpb.monteiro.ads.sisap.service.BimestreService;

/**
 * Esta classe recebe um aluno que vem da tela de listagens e busca informações
 * deste aluno. O boletim do aluno deve ser mostrado/visualizado pelo usuário
 * aqui.
 * 
 * @author Deivid, Widancássio
 *
 */
@Named
@ConversationScoped
public class VisualizarBoletimBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private Aluno aluno;
	String matriculaAluno;
	String nomeAluno;

	private List<Bimestre> bimestres;

	@Inject
	private AlunoService alunoService;

	@Inject
	private BimestreService bimestreService;

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
		if (bimestres == null) {
			bimestres = new ArrayList<Bimestre>();
		}
	}

	/**
	 * Método para realizar a busca do aluno através da matricula do mesmo.
	 * 
	 * @return
	 * @throws SisapException
	 */
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

	/**
	 * Limpar os campos de matricula e nome do aluno.
	 */
	public void limpar() {
		matriculaAluno = null;
		nomeAluno = null;
	}

	/**
	 * Ao selecionar este método uma POP-UP é aberta com a listagem de todos os
	 * alunos presentes no banco de dados. Essa listagem acontece no momento em
	 * que se clica na lupa para realizar a busca do aluno que se deseja.
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
	 * Um aluno deve ser selecionado na POP-UP e ter sua matricula inserida no
	 * campo correspondente automaticamente.
	 * 
	 * @param aluno
	 */
	public void selecionarAluno(Aluno aluno) {
		RequestContext.getCurrentInstance().closeDialog(aluno);
	}

	/**
	 * Método para capturar o aluno selecionado na tela. A entidade aluno é
	 * capturada e as informações de matricula e nome são setadas em dois
	 * atributos presentes nesta classe.
	 * 
	 * @param event
	 */
	public void alunoSelecionado(SelectEvent event) {
		aluno = (Aluno) event.getObject();
		matriculaAluno = aluno.getMatricula();
		nomeAluno = aluno.getNome();
	}

	public List<Bimestre> getBimestres() throws SisapException {
		return bimestreService.buscarNotasDoAluno(aluno.getMatricula());

	}

}
