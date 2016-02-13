package br.edu.ifpb.monteiro.ads.sisap.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.dao.PedagogoDAO;
import br.edu.ifpb.monteiro.ads.sisap.entities.Pedagogo;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.util.TransacionalCdi;

public class PedagogoService implements Serializable {

	private static final Log LOGGER = LogFactory.getLog(PedagogoService.class);

	private static final long serialVersionUID = -8713392833366563250L;

	@Inject
	private transient PedagogoDAO pedagogoDAO;

	public PedagogoDAO getPedagogoDAO() {
		return pedagogoDAO;
	}

	public void setPedagogoDAO(PedagogoDAO pedagogoDAO) {
		this.pedagogoDAO = pedagogoDAO;
	}

	/**
	 * Metodo para salvar um novo pedagogo, chamando a classe pedagogoDAO onde a
	 * entidade em questao devera ser persistida no banco.
	 * 
	 * @param pedagogo
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void salvar(Pedagogo pedagogo) throws SisapException {
		this.pedagogoDAO.salvar(pedagogo);

	}

	/**
	 * Este metodo atualiza um determinado pedagogo que esta sendo passado como
	 * parametro. Sera chamado o pedagogoDAO que fara a busca no banco e ira
	 * alterar os dados que foram modificados.
	 * 
	 * @param pedagogo
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Pedagogo atualizar(Pedagogo pedagogo) throws SisapException {
		return pedagogoDAO.atualizar(pedagogo);
	}

	/**
	 * Metodo para remover um pedagogo do cadastro de usuarios no banco. Sera
	 * chamado o pedagogoDAO que fara a busca deste registro e removera o
	 * cadastro do mesmo.
	 * 
	 * @param pedagogo
	 * @throws SisapException
	 */
	@TransacionalCdi
	public void remover(Pedagogo pedagogo) throws SisapException {
		this.pedagogoDAO.remover(pedagogo);

	}

	/**
	 * Metodo para realizar a busca do pedagogo pelo identificador (ID) do
	 * mesmo. O id deve ser passado como parametro para que a busca no banco
	 * possa ser realizada, retornando o cadastro referente.
	 * 
	 * @param idPedagogo
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Pedagogo buscarPorId(Long idPedagogo) throws SisapException {
		return this.pedagogoDAO.buscarPorId(idPedagogo);
	}

	/**
	 * Metodo que realiza a busca do pedagogo atraves da matricula passada como
	 * parametro no metodo.
	 * 
	 * @param matricula
	 *            A matricula recebida eh do tipo String, porem eh feito um cast
	 *            na chamada do metodo da classe pdagogoDAO para que a busca
	 *            seja realizada, ja que o metodo no DAO deve receber a
	 *            matricula no tipo Long.
	 * @return
	 * @throws SisapException
	 */
	@TransacionalCdi
	public Pedagogo buscarPorMatricula(String matricula) throws SisapException {
		return ((PedagogoDAO) this.pedagogoDAO).buscarPorMatricula(matricula);

	}

	/**
	 * Neste metodo eh passado a entidade pedagogo e eh chamado outro metodo
	 * nesta classe que realiza a criptografia da senha da entidade em questao.
	 * 
	 * @param pedagogo
	 * @throws SisapException
	 */
	public void criptografarSenha(Pedagogo pedagogo) throws SisapException {
		pedagogo.setSenha(criptografarSenha(pedagogo.getSenha()));
	}

	/**
	 * Metodo privado para realizar a criptografia da senha que esta sendo
	 * passada como parametro. A senha eh calculada atraves do conjunto de
	 * funcoes hash criptograficas SHA-2 projetadas pela NSA (Agencia de
	 * Seguranca Nacional dos EUA).
	 * 
	 * @param senha
	 *            senha a ser criptografada neste metodo.
	 * @return senha criptografada
	 * @throws SisapException
	 */
	private static String criptografarSenha(String senha) throws SisapException {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(senha.getBytes("UTF-8")); // Change this to "UTF-16" if
												// needed
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			return bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.warn("Nao foi possivel criptografar a senha!", e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn("Nao foi possivel criptografar a senha!", e);
		}
		return null;
	}

	public List<Pedagogo> getAll(String matriculaPedagogo, String nomePedagogo)
			throws SisapException {
		try {
			return this.pedagogoDAO.getAll(matriculaPedagogo, nomePedagogo);
		} catch (PersistenceException e) {
			throw new SisapException(e.getMessage(), e);
		}
	}

}
