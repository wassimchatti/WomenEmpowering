package tn.EW.womenEmpowering.services;

import java.util.List;

import javax.ejb.Remote;

import tn.EW.womenEmpowering.entityProduit.Product;



@Remote
public interface productServiceRemote  {
 
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct (int id);
	public List<Product> getAllProduct();
	public int DeadlinePromotion(int productId);
	
}
