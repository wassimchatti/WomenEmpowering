package tn.EW.womenEmpowering.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.EW.womenEmpowering.entityProduit.CommentProduct;


@Remote
public interface commentServiceRemote {
	public void AddComment(int idP , int idU , Date date ,String comment);
	public void DeleteComment(int idC);
	public List<CommentProduct> getAllComment();
	public List<CommentProduct> getAllComment(int idProduct);

}
