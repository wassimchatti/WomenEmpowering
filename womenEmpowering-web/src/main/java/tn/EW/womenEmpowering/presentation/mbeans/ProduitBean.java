package tn.EW.womenEmpowering.presentation.mbeans;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.EW.womenEmpowering.entityProduit.CategorieProduct;
import tn.EW.womenEmpowering.entityProduit.CommentProduct;

import tn.EW.womenEmpowering.entityProduit.Product;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;
import tn.EW.womenEmpowering.services.categorieService;
import tn.EW.womenEmpowering.services.commentService;
import tn.EW.womenEmpowering.services.favorisService;
import tn.EW.womenEmpowering.services.productService;

@ManagedBean
@SessionScoped
public class ProduitBean {

	private String nomProduit;
	private String nomComment;
	private Date date ;
	private Date dateFinpromotion;
	private int quantite ;
	private float price;
	private int promotion ;
	private String description ;
	private Integer produitIdToUpdate ;
	private Integer selectedCategorieId;
	private List<Product> produits ;
	private List<CategorieProduct> categoriesProduits;
	private Integer userConnect ;
	private List<CommentProduct> comments;
	private List<String> favoris;
	private int idcomment;
	
	@EJB
	productService ps ;

	@EJB
	categorieService cs ;
	
	@EJB
	favorisService fs;
	
	@EJB
	commentService commentS;
	
	
	
	
	
	public List<String> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<String> favoris) {
		this.favoris = favoris;
	}

	public Date getDateFinpromotion() {
		return dateFinpromotion;
	}

	public void setDateFinpromotion(Date dateFinpromotion) {
		this.dateFinpromotion = dateFinpromotion;
	}

	public int getIdcomment() {
		return idcomment;
	}

	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}

	public List<CommentProduct> getComments() {
		return comments;
	}

	public void setComments(List<CommentProduct> comments) {
		this.comments = comments;
	}

	public Integer getUserConnect() {
		return userConnect;
	}

	public void setUserConnect(Integer userConnect) {
		this.userConnect = userConnect;
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

	public Integer getSelectedCategorieId() {
		return selectedCategorieId;
	}

	public void setSelectedCategorieId(Integer selectedCategorieId) {
		this.selectedCategorieId = selectedCategorieId;
	}

	public List<CategorieProduct> getCategoriesProduits() {
		return categoriesProduits;
	}

	public void setCategoriesProduits(List<CategorieProduct> categoriesProduits) {
		this.categoriesProduits = categoriesProduits;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProduitIdToUpdate() {
		return produitIdToUpdate;
	}

	public void setProduitIdToUpdate(Integer produitIdToUpdate) {
		this.produitIdToUpdate = produitIdToUpdate;
	}

	public List<Product> getProduits() {
		return produits;
	}

	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}
	
	
	public String getNomComment() {
		return nomComment;
	}

	public void setNomComment(String nomComment) {
		this.nomComment = nomComment;
	}

	@PostConstruct
	public void init(){
		date = new Date();
		
		categoriesProduits = cs.getAllCategorie();
	}
	
	public String ajouteProduit()throws ParseException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Date creation : "+simpleFormat.format(date));
	   Product p =new Product(nomProduit,date,price,description,quantite,promotion,dateFinpromotion);
	   
	   CategorieProduct selectedCategorie = new CategorieProduct();
	   selectedCategorie.setCategorieId(selectedCategorieId);
	   p.setCategorie(selectedCategorie);
	   ps.addProduct(p);
	   return "/pages/admin/AffichageProduit";
	}
	
	public List<Product> getProduitAll(){
		
		produits=ps.getAllProduct();
		return produits;
	}
	
	
	public void SupprimerProduit(Integer produitID){
		ps.deleteProduct(produitID);
	}
	
	
	public void modifierProduit(Product pd){
		this.setNomProduit(pd.getNameProduct());
		this.setDate(pd.getDateProduct());
		this.setPrice(pd.getPriceProduct());
		this.setDescription(pd.getDescription());
		this.setQuantite(pd.getQuantite());
		this.setProduitIdToUpdate(pd.getProductId());
		
	}
	
	public String AfficheDetail(Product pd){
		this.setNomProduit(pd.getNameProduct());
		this.setDate(pd.getDateProduct());
		this.setPrice(pd.getPriceProduct());
		this.setDescription(pd.getDescription());
		this.setQuantite(pd.getQuantite());
		this.setProduitIdToUpdate(pd.getProductId());
		this.setPromotion(pd.getPromotion());
		this.setDateFinpromotion(pd.getDateFinPromotion());
		return "/FrontOffice/DetailProduit?faces-redirect=true";
	}
	
	
   public void mettreAjourProduit(){
		Product p = new Product(produitIdToUpdate,nomProduit,date,price,description,quantite,promotion,dateFinpromotion);
		CategorieProduct selectedCategorie = new CategorieProduct();
		   selectedCategorie.setCategorieId(selectedCategorieId);
		   p.setCategorie(selectedCategorie);
          ps.updateProduct(p);
	}

  public void ajouteFavoris()throws ParseException{
	 // FavorisProduct f = new FavorisProduct();
	  Utilisateur uts = new Utilisateur();
	  if (fs.getAllFavorisExist(produitIdToUpdate, 2)==null){
	   fs.AddFavoris(produitIdToUpdate,2,date);}
	}
  
  public void deleteFavoris(){
	  fs.AnnulerFavoris(produitIdToUpdate, 2);
  }
  
  public List<String> getFavoisAll(){
		favoris = fs.getAllFavoris();
		
		return favoris;
	}
  
  
  public void ajouteComment()throws ParseException{
	Date dateSyst = new Date();
	   //   Utilisateur u = new Utilisateur();
	    //  userConnect = u.getId();
		 commentS.AddComment(produitIdToUpdate, 2, dateSyst,nomComment);
		  
		}
  
  public List<CommentProduct> getCommentAll(){
		comments = commentS.getAllComment();
	    return comments;
	}
  
  
  

  

  
  
  public String printDifference() throws ViewExpiredException {
	//  SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
              Date dateSys = new Date();
			//in milliseconds
              
              if(dateFinpromotion.getTime()>=dateSys.getTime()){
			long diff = dateFinpromotion.getTime() - dateSys.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			if (diffDays==0 && diffHours==0 && diffMinutes==0 && diffSeconds>0 && diffSeconds<4) {
          	  ps.DeadlinePromotion(produitIdToUpdate);
          	  return "Fin de Promotion ... ";
			}

			// System.out.println("tesssssssssssssssssssst : "+dateFormat.format(dateSys));	
 return diffDays + " days, "+diffHours + ":"+diffMinutes + ":"+diffSeconds ;
              }
           
             else{
            	
   				return "";
				
			}
              
 		


  }
  
  
  
  
  
  
}
