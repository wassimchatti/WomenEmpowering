package tn.EW.womenEmpowering.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.EW.womenEmpowering.entityProduit.Role;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;
import tn.EW.womenEmpowering.services.utilisateurService;




@ManagedBean
@SessionScoped 
public class loginBean {
	private Integer userid ;
	private String email;
	private String password;
	private Utilisateur user;
	private boolean loggedIn;  // default is false.
	
	@EJB
	utilisateurService userservice;
	
	
	
	
	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public String  doLogin(){
		String 	nvigateTo ="null";
		user = userservice.getUtilisateurByEmailAndPassword(email, password);
				
		
		if(user != null && user.getRole() == Role.Admin){
				nvigateTo = "/pages/admin/Backoffice?faces-redirect=true";
				loggedIn = true;
		}
		else if (user != null && user.getRole() == Role.Member){
			
			nvigateTo = "/FrontOffice/Acceuil?faces-redirect=true";
			loggedIn = true;
		}
		else{
			FacesContext.getCurrentInstance().addMessage("form:btn", new  FacesMessage("bad credentials!!"));
		}
	return nvigateTo;
		
	}
	
	
	public String  doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/admin/login?faces-redirect=true";
	}
	
	
	
	
	
}
