package tn.EW.womenEmpowering.entityProduit;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String adresseMail;
	private boolean isActif;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<FavorisProduct> favoris;
	
	@OneToMany(mappedBy="user")
	private List<CommentProduct> comments;
	
	
	
	public List<CommentProduct> getComments() {
		return comments;
	}
	public void setComments(List<CommentProduct> comments) {
		this.comments = comments;
	}
	public List<FavorisProduct> getFavoris() {
		return favoris;
	}
	public void setFavoris(List<FavorisProduct> favoris) {
		this.favoris = favoris;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utilisateur(String nom, String prenom, String adresseMail, boolean isActif, Role role, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.isActif = isActif;
		this.role = role;
		this.password = password;
	}
	public Utilisateur() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
