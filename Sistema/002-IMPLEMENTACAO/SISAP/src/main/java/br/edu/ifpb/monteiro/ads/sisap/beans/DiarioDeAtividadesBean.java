package br.edu.ifpb.monteiro.ads.sisap.beans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.ifpb.monteiro.ads.sisap.entities.Atividade;
import br.edu.ifpb.monteiro.ads.sisap.exception.SisapException;
import br.edu.ifpb.monteiro.ads.sisap.service.DiarioDeAtividadesService;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

@Named
@ConversationScoped
public class DiarioDeAtividadesBean extends ClasseAbstrata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977557276403647255L;

	private static final Log LOGGER = LogFactory
			.getLog(DiarioDeAtividadesBean.class);

	private List<Atividade> atividadesDoPedagogo;

	private Atividade atividade = new Atividade();

	@Inject
	private DiarioDeAtividadesService atividadesDoPedagogoService;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		filtrar();
	}

	public void preRenderView() {
		if (atividade == null) {
			atividade = new Atividade();
		}
		if (atividadesDoPedagogo == null) {
			atividadesDoPedagogo = new ArrayList<Atividade>();
		}
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Atividade> getAtividadesDoPedagogo() {
		return atividadesDoPedagogo;
	}

	public void setAtividadesDoPedagogo(List<Atividade> atividadesDoPedagogo) {
		this.atividadesDoPedagogo = atividadesDoPedagogo;
	}

	public void filtrar() {
		try {
			atividadesDoPedagogo = atividadesDoPedagogoService.getAll();
		} catch (SisapException e) {
			reportarMensagemDeErro(e.getMessage());
			LOGGER.warn(e);
		}
	}

	/**
	 * Método de processamento do documento PDF antes que ele seja aberto. Aqui
	 * setamos um titulo para o documento, uma imagem e parágrafos. Tudo para
	 * configurar o documento e abri-lo conforme especificado aqui.
	 * 
	 * @param document
	 * @throws IOException
	 * @throws BadElementException
	 * @throws DocumentException
	 */
	public void preProcessPDF(Object document) throws IOException,
			BadElementException, DocumentException {
		// cria o documento
		Document pdf = (Document) document;
		// setando a margin e página, precisa estar antes da abertura do
		// documento, ou seja da linha: pdf.open()
		pdf.setMargins(5, 5, 5, 5);
		pdf.setPageSize(PageSize.A4);
		pdf.addTitle("Registro de Atividades");
		pdf.open();
		// aqui pega o contexto para formar a url da imagem
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator
				+ "resources/" + File.separator + "logo_title.png";
		// cria a imagem e passando a url
		Image image = Image.getInstance(logo);
		// alinha ao centro
		image.setAlignment(Image.ALIGN_CENTER);
		// adciona a img ao pdf
		pdf.add(image);
		// adiciona um paragrafo ao pdf, alinha também ao centro
		Paragraph p = new Paragraph("Registro de Atividades");
		// adicionando outro paragrafo para o anterior não ficar colado à tabela
		Paragraph p2 = new Paragraph("-");
		p.setAlignment("center");
		p2.setAlignment("center");
		pdf.add(p);
		pdf.add(p2);
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}
