package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.embedded.Endereco;
import br.edu.ifpb.monteiro.ads.sisap.entities.Contato;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pessoa;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;
import br.edu.ifpb.monteiro.ads.sisap.service.PedagogoService;

@Named
@ConversationScoped
public class EditarPedagogoBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7928640369695996239L;

	private static final Log LOGGER = LogFactory
			.getLog(EditarPedagogoBean.class);

	private Pessoa pessoa;
	private Pedagogo pedagogo;
	private Contato contato;
	private Contato contatoPessoa;
	private Endereco endereco;

	@Inject
	private PedagogoService pedagogoService;

	@Inject
	private Conversation conversation;

	public void preRenderView() {
		if (pedagogo == null) {
			pedagogo = new Pedagogo();
		}
		if (pessoa == null) {
			pessoa = new Pessoa();
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

	/**
	 * Metodo para salvar o usuario que esta sendo cadastrado ou que esta tendo
	 * seus dados alterados.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public String salvarUsuario() throws SisapException {
		conversation.end();
		// comparacao do equals abaixo: a string esta no inicio como dica do
		// jenkins para compilacao
		if (pessoa.getId() != null) {
			this.pedagogo = atributosPedagogo();
			pedagogoService.atualizar(pedagogo);
			reportarMensagemDeSucesso("Dados atualizados com sucesso!");
			return EnderecoPaginas.PAGINA_PRINCIPAL_PEDAGOGO;
		}
		// comparacao do equals abaixo: a string esta no inicio como
		// dica do
		// jenkins para compilacao
		else if (pessoa.getId() == null) {
			this.pedagogo = atributosPedagogo();
			pedagogoService.salvar(pedagogo);
			reportarMensagemDeSucesso("Usuario criado com sucesso!");
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL_ADMIN;
	}

	/**
	 * Captura os atributos do pedagogo inseridos nos campos da view. Seta todos
	 * os valores (novos, caso seja alteracao de dados ou nao) e retorna a
	 * entidade pedagogo com os novos (ou nao) valores.
	 * 
	 * @return
	 */
	public Pedagogo atributosPedagogo() {
		if (pessoa.getId() != null) {
			pedagogo.setContato(pessoa.getContato());
			pedagogo.setEndereco(pessoa.getEndereco());
		} else {
			contato.setPessoa(pedagogo);
			pedagogo.setContato(contato);
			pedagogo.setEndereco(endereco);
		}
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
		pedagogo.setId(pessoa.getId());
		try {
			pedagogoService.criptografarSenha(pedagogo);
		} catch (RollbackException | SisapException e) {
			LOGGER.warn(e);
		}

		return pedagogo;
	}

	/**
	 * Metodo que captura a pessoa (Usuario do sistema) logado no momento.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public Pessoa getUsuarioLogado() throws SisapException {
		FacesContext fc = FacesContext.getCurrentInstance();
		String usuarioSessao = fc.getExternalContext().getUserPrincipal()
				.getName();

		Pessoa temp = pedagogoService.buscarPorMatricula(usuarioSessao);
		pessoa = temp;

		return temp;
	}

	/**
	 * Metodo para capturar o contato do usuario logado no sistema no momento.
	 * 
	 * @return
	 * @throws SisapException
	 */
	public Contato getContatoUsuario() throws SisapException {
		return getUsuarioLogado().getContato();

	}

	/**
	 * Capturar o contato da pessoa logada.
	 * 
	 * @return
	 */
	public Contato getContatosPessoa() {
		return contatoPessoa;
	}

	public void setContatosPessoa(Contato contatoPessoa) {
		this.contatoPessoa = contatoPessoa;
	}

}
