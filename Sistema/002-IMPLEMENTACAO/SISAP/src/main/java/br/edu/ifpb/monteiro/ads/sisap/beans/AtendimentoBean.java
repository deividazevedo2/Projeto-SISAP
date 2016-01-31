package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Aluno;
import br.edu.ifpb.monteiro.ads.sisap.entities.Atendimento;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.AlunoService;
import br.edu.ifpb.monteiro.ads.sisap.service.AtendimentoService;

@Named
@RequestScoped
public class AtendimentoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private List<Aluno> alunos;
	private String matricula;
	private Aluno aluno;
	private Atendimento atendimento;

	@Inject
	private AlunoService alunoService;

	@Inject
	private AtendimentoService atendimentoService;

	@Inject
	private Conversation conversation;

	private String matriculaAluno;
	private String nomeAluno;

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

	public Aluno buscarAlunoPorMatricula() throws SisapException {

		this.aluno = alunoService.buscarPorMatricula(matricula);

		return aluno;
	}

	public String salvarAtendimento() throws SisapException {
		conversation.end();
		atendimento.setAluno(aluno);
		atendimentoService.salvar(atendimento);
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

	public void filtrar() {
		try {
			alunos = alunoService.getAll(matriculaAluno, nomeAluno);
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}

	public void limpar() {
		nomeAluno = null;
		matriculaAluno = null;
	}

}
