package tn.EW.womenEmpowering.presentation.mbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.EW.womenEmpowering.entityProduit.CategorieProduct;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;
import tn.EW.womenEmpowering.services.categorieService;
import tn.EW.womenEmpowering.services.utilisateurService;



@ManagedBean
@SessionScoped
public class categorieBean {
	
	private String nameCategorie;
	private Date dateCategorie;
	private List<CategorieProduct> categoriesPro ;
	private Integer categorieIdToBeUpdate;
	
	
	@EJB
	categorieService catservice;
	
	

	
	

	public Integer getCategorieIdToBeUpdate() {
		return categorieIdToBeUpdate;
	}

	public void setCategorieIdToBeUpdate(Integer categorieIdToBeUpdate) {
		this.categorieIdToBeUpdate = categorieIdToBeUpdate;
	}

	public List<CategorieProduct> getCategoriesPro() {
		return categoriesPro;
	}

	public void setCategoriesPro(List<CategorieProduct> categoriesPro) {
		this.categoriesPro = categoriesPro;
	}

	public String getNameCategorie() {
		return nameCategorie;
	}

	public void setNameCategorie(String nameCategorie) {
		this.nameCategorie = nameCategorie;
	}

	public Date getDateCategorie() {
		return dateCategorie;
	}

	public void setDateCategorie(Date dateCategorie) {
		this.dateCategorie = dateCategorie;
	}
	
	@PostConstruct
	public void init(){
		dateCategorie = new Date();
	}
	
	public String ajouteCategorie()throws ParseException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Date debut : "+simpleFormat.format(dateCategorie));
	   
	   CategorieProduct cat = new CategorieProduct(nameCategorie,dateCategorie);
	   catservice.addCategorie(cat);
	   return "/pages/admin/AffichageCategorie";
	}

	
	public List<CategorieProduct> getCategoriesAll(){
		
		categoriesPro = catservice.getAllCategorie();
		 return categoriesPro;
	}
	
	public void supprimerCategorie (Integer categorieID){
		catservice.deleteCategorie(categorieID);
	}
	
	public void modifierCategorie(CategorieProduct cat){
		this.setNameCategorie(cat.getNameCategorie());
		this.setDateCategorie(cat.getDateCategorie());
		this.setCategorieIdToBeUpdate(cat.getCategorieId());
		
		
	}
	
	public void mettreAjourCategorie(){
		
		
          catservice.updateCategorie(new CategorieProduct(categorieIdToBeUpdate,nameCategorie,dateCategorie));
	}
}
