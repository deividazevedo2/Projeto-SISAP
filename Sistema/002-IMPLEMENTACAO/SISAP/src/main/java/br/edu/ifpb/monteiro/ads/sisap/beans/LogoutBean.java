package br.edu.ifpb.monteiro.ads.sisap.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.monteiro.ads.sisap.redirecionamentos.EnderecoPaginas;


@Named
@RequestScoped
public class LogoutBean {

	public String efetuarLogout(){  
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
        session.invalidate();  
        return EnderecoPaginas.PAGINA_PRINCIPAL_LOGIN;
    } 
	
}
