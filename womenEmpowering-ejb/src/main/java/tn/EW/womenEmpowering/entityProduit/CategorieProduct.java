package tn.EW.womenEmpowering.entityProduit;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CategorieProduct implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categorieId;
	private String nameCategorie;
	private Date dateCategorie;
	
	@OneToMany(mappedBy="categorie")
	private List<Product> products;
	
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getCategorieId() {
		return categorieId;
	}
	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
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
	public CategorieProduct( String nameCategorie, Date dateCategorie) {
		super();
		
		this.nameCategorie = nameCategorie;
		this.dateCategorie = dateCategorie;
	}
	public CategorieProduct() {
		
	}
	@Override
	public String toString() {
		return "CategorieOffer [nameCategorie=" + nameCategorie + ", dateCategorie=" + dateCategorie + "]";
	}
	public CategorieProduct(int categorieId, String nameCategorie, Date dateCategorie) {
		super();
		this.categorieId = categorieId;
		this.nameCategorie = nameCategorie;
		this.dateCategorie = dateCategorie;
	}
	public CategorieProduct(int categorieId, String nameCategorie) {
		super();
		this.categorieId = categorieId;
		this.nameCategorie = nameCategorie;
	}
	
	
	
	
}
