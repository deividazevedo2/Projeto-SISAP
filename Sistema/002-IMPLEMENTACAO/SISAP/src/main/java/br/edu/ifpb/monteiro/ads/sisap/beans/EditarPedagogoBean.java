package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
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
	private Contato contato;
	private Endereco endereco;
	private List<Contato> contatos = new ArrayList<Contato>();

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
		if (contato == null) {
			contato = new Contato();
		}
		if (endereco == null) {
			endereco = new Endereco();
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String salvarUsuario() throws SisapException {
		conversation.end();
		try {
			if (pessoa.getId() != null && pessoa.getGrupo().equals("pedagogo")) {
				pedagogoService.atualizar(atributosPedagogo());
				reportarMensagemDeSucesso("Usuario atualizado com sucesso!");
			} else if (pessoa.getId() == null
					&& pessoa.getGrupo().equals("pedagogo")) {
				pedagogoService.salvar(atributosPedagogo());
				reportarMensagemDeSucesso("Usuario criado com sucesso!");
			} else if (pessoa.getId() != null
					&& pessoa.getGrupo().equals("professor")) {
				professorService.atualizar(atributosProfessor());
				reportarMensagemDeSucesso("Usuario atualizado com sucesso!");
			} else if (pessoa.getId() == null
					&& pessoa.getGrupo().equals("professor")) {
				professorService.salvar(atributosProfessor());
				reportarMensagemDeSucesso("Usuario criado com sucesso!");
			}
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
		}

		return EnderecoPaginas.PAGINA_PRINCIPAL_ADMIN;
	}

	public Pedagogo atributosPedagogo() {
		contato.setCelular(contato.getCelular());
		contato.setEmail(contato.getEmail());
		contato.setFacebok(contato.getFacebok());
		contato.setTwitter(contato.getTwitter());
		contato.setTelefoneResidencial(contato.getTelefoneResidencial());
		contato.setTelefoneTrabalho(contato.getTelefoneTrabalho());
		endereco.setRua(endereco.getRua());
		endereco.setNumero(endereco.getNumero());
		endereco.setBairro(endereco.getBairro());
		endereco.setCidade(endereco.getCidade());
		endereco.setCep(endereco.getCep());
		endereco.setUf(endereco.getUf());
		pedagogo.setPrimeiroNome(pessoa.getPrimeiroNome());
		pedagogo.setSegundoNome(pessoa.getSegundoNome());
		pedagogo.setCpf(pessoa.getCpf());
		pedagogo.setDataNascimento(pessoa.getDataNascimento());
		pedagogo.setNaturalidade(pessoa.getNaturalidade());
		pedagogo.setMatriculaSuap(pessoa.getMatriculaSuap());
		pedagogo.setSexo(pessoa.getSexo());
		pedagogo.setSenha(pessoa.getSenha());
		pedagogo.setGrupo(pessoa.getGrupo());
		pedagogo.setRg(pessoa.getRg());
		pedagogo.setSenha(pessoa.getSenha());
		contatos.add(contato);
		pedagogo.setContatos(contatos);
		pedagogo.setEndereco(endereco);

		return pedagogo;
	}

	public Professor atributosProfessor() {
		contato.setCelular(contato.getCelular());
		contato.setEmail(contato.getEmail());
		contato.setFacebok(contato.getFacebok());
		contato.setTwitter(contato.getTwitter());
		contato.setTelefoneResidencial(contato.getTelefoneResidencial());
		contato.setTelefoneTrabalho(contato.getTelefoneTrabalho());
		endereco.setRua(endereco.getRua());
		endereco.setNumero(endereco.getNumero());
		endereco.setBairro(endereco.getBairro());
		endereco.setCidade(endereco.getCidade());
		endereco.setCep(endereco.getCep());
		endereco.setUf(endereco.getUf());
		professor.setPrimeiroNome(pessoa.getPrimeiroNome());
		professor.setSegundoNome(pessoa.getSegundoNome());
		professor.setCpf(pessoa.getCpf());
		professor.setDataNascimento(pessoa.getDataNascimento());
		professor.setNaturalidade(pessoa.getNaturalidade());
		professor.setMatriculaSuap(pessoa.getMatriculaSuap());
		professor.setSexo(pessoa.getSexo());
		professor.setSenha(pessoa.getSenha());
		professor.setGrupo(pessoa.getGrupo());
		professor.setRg(pessoa.getRg());
		professor.setSenha(pessoa.getSenha());
		contatos.add(contato);
		professor.setContatos(contatos);
		professor.setEndereco(endereco);

		return professor;
	}

	public String getIdUsuarioLogado() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String usuarioSessao = fc.getExternalContext().getUserPrincipal()
				.getName();

		return usuarioSessao;
	}

}
