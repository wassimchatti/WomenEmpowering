package tn.EW.womenEmpowering.entityProduit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentProduct implements Serializable {

	@EmbeddedId
	private CommentProductPK commentproductPK ;
	
	private String nomComment ;
	
	@ManyToOne
	@JoinColumn(name="idUser",referencedColumnName="id", insertable=false,updatable=false)
	private Utilisateur user;
	
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="productId", insertable=false,updatable=false)
	private Product produit ;

	public CommentProductPK getCommentproductPK() {
		return commentproductPK;
	}

	public void setCommentproductPK(CommentProductPK commentproductPK) {
		this.commentproductPK = commentproductPK;
	}

	

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Product getProduit() {
		return produit;
	}

	public void setProduit(Product produit) {
		this.produit = produit;
	}

	public String getNomComment() {
		return nomComment;
	}

	public void setNomComment(String nomComment) {
		this.nomComment = nomComment;
	}

	
	
	
}
