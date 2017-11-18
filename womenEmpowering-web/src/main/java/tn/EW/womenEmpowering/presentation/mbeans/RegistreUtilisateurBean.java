package tn.EW.womenEmpowering.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.EW.womenEmpowering.entityProduit.Role;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;
import tn.EW.womenEmpowering.services.utilisateurService;



@ManagedBean
@SessionScoped
public class RegistreUtilisateurBean {
	private String prenom;
	private String nom;
	private String password;
	private String email;
	private Boolean isActif;
	private Role role ;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@EJB
	utilisateurService userService ;
	
	public String ajouterUser(){
		
		Utilisateur u = new Utilisateur(nom,prenom,email,isActif,role,password);
		userService.AddUser(u);
		
		return "/pages/admin/login?faces-redirect=true";
		}
}
