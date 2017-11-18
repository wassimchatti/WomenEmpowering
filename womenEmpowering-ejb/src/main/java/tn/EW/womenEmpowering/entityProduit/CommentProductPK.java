package tn.EW.womenEmpowering.entityProduit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class CommentProductPK implements Serializable {
	
	
	
	private int idProduct ;
	private int idUser ;
	private Date dateComment ;
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDateComment() {
		return dateComment;
	}
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	public CommentProductPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateComment == null) ? 0 : dateComment.hashCode());
		result = prime * result + idProduct;
		result = prime * result + idUser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentProductPK other = (CommentProductPK) obj;
		if (dateComment == null) {
			if (other.dateComment != null)
				return false;
		} else if (!dateComment.equals(other.dateComment))
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	
	
}
