package tn.EW.womenEmpowering.entityProduit;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private int promotion ;
	private String nameProduct;
	private Date dateProduct;
	private Date dateFinPromotion ;
	private float priceProduct;
	private String description;
	private int quantite;
	
	@OneToMany(mappedBy="produit")
	private List<FavorisProduct> favoris;
	
	@OneToMany(mappedBy="produit")
	private List<CommentProduct> comments ;
	
	
	
	
	public Date getDateFinPromotion() {
		return dateFinPromotion;
	}
	public void setDateFinPromotion(Date dateFinPromotion) {
		this.dateFinPromotion = dateFinPromotion;
	}
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
	@ManyToOne
	private CategorieProduct categorie;
	
	public CategorieProduct getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProduct categorie) {
		this.categorie = categorie;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Date getDateProduct() {
		return dateProduct;
	}
	public void setDateProduct(Date dateProduct) {
		this.dateProduct = dateProduct;
	}
	public float getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Product() {
		
	}
	
	public Product(String nameProduct, Date dateProduct, float priceProduct, String description,Date dateFinPromotion) {
		super();
		this.nameProduct = nameProduct;
		this.dateProduct = dateProduct;
		this.priceProduct = priceProduct;
		this.description = description;
		this.dateFinPromotion=dateFinPromotion ;
	}
	public Product(int productId, String nameProduct, Date dateProduct, float priceProduct, String description,Date dateFinPromotion) {
		
		this.productId = productId;
		this.nameProduct = nameProduct;
		this.dateProduct = dateProduct;
		this.priceProduct = priceProduct;
		this.description = description;
		this.dateFinPromotion=dateFinPromotion ;
	}
	public Product(int productId, String nameProduct, Date dateProduct, float priceProduct, String description,
			int quantite, int promotion,Date dateFinPromotion) {
		super();
		this.productId = productId;
		this.nameProduct = nameProduct;
		this.dateProduct = dateProduct;
		this.priceProduct = priceProduct;
		this.description = description;
		this.quantite = quantite;
		this.promotion=promotion;
		this.dateFinPromotion=dateFinPromotion ;
	}
	public Product(String nameProduct, Date dateProduct, float priceProduct, String description, int quantite, int promotion,Date dateFinPromotion) {
		super();
		this.nameProduct = nameProduct;
		this.dateProduct = dateProduct;
		this.priceProduct = priceProduct;
		this.description = description;
		this.quantite = quantite;
		this.promotion=promotion;
		this.dateFinPromotion=dateFinPromotion ;
	}
	public Product(int productId, int promotion, Date dateFinPromotion) {
		super();
		this.productId = productId;
		this.promotion = promotion;
		this.dateFinPromotion = dateFinPromotion;
	}
	
	
	
	
	
	
	
}

