package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pessoa;
import br.edu.ifpb.monteiro.ads.sisap.entities.Professor;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;
import br.edu.ifpb.monteiro.ads.sisap.service.ProfessorService;

@Named
@ConversationScoped
public class EditarPedagogoBean extends ClasseAbstrata {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Pedagogo pedagogo;
	private Professor professor;

	@Inject
	private PedagogoService pedagogoService;

	@Inject
	private ProfessorService professorService;

	@Inject
	private Conversation conversation;

	public void preRenderView() {
		if (pedagogo == null) {
			pedagogo = new Pedagogo();
		}
		if (professor == null) {
			professor = new Professor();
		}
		if (pessoa == null) {
			pessoa = new Professor();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public Pedagogo getPedagogo() {
		return pedagogo;
	}

	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String salvarUsuario() throws SisapException {
		conversation.end();
		try {
			if (pessoa.getId() != null && pessoa.getGrupo().equals("pedagogo")) {
				pedagogoService.atualizar(atributosPedagogo());
				reportarMensagemDeSucesso("Usuário atualizado com sucesso!");
			} else if (pessoa.getId() == null
					&& pessoa.getGrupo().equals("pedagogo")) {
				pedagogoService.salvar(atributosPedagogo());
				reportarMensagemDeSucesso("Usuário criado com sucesso!");
			} else if (pessoa.getId() != null
					&& pessoa.getGrupo().equals("professor")) {
				professorService.atualizar(atributosProfessor());
				reportarMensagemDeSucesso("Usuário atualizado com sucesso!");
			} else if (pessoa.getId() == null
					&& pessoa.getGrupo().equals("professor")) {
				professorService.salvar(atributosProfessor());
				reportarMensagemDeSucesso("Usuário criado com sucesso!");
			}
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
		}

		return EnderecoPaginas.PAGINA_PRINCIPAL_ADMIN;
	}

	public Pedagogo atributosPedagogo() {
		pedagogo.setPrimeiroNome(pessoa.getPrimeiroNome());
		pedagogo.setSegundoNome(pessoa.getSegundoNome());
		pedagogo.setCpf(pessoa.getCpf());
		pedagogo.setMatriculaSuap(pessoa.getMatriculaSuap());
		pedagogo.setSenha(pessoa.getSenha());
		pedagogo.setGrupo(pessoa.getGrupo());
		pedagogo.setRg(pessoa.getRg());

		return pedagogo;
	}

	public Professor atributosProfessor() {
		professor.setPrimeiroNome(pessoa.getPrimeiroNome());
		professor.setSegundoNome(pessoa.getSegundoNome());
		professor.setCpf(pessoa.getCpf());
		professor.setMatriculaSuap(pessoa.getMatriculaSuap());
		professor.setSenha(pessoa.getSenha());
		professor.setGrupo(pessoa.getGrupo());
		professor.setRg(pessoa.getRg());

		return professor;
	}

}
