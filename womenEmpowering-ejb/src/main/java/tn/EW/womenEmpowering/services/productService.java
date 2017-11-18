package tn.EW.womenEmpowering.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.EW.womenEmpowering.entityProduit.Product;


@LocalBean
@Stateless
public class productService implements productServiceRemote {

	@PersistenceContext(unitName="womenEmpowering-ejb")
	EntityManager em;
	@Override
	public void addProduct(Product product) {
         em.persist(product);		
	}

	@Override
	public void updateProduct(Product product) {
		em.merge(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		Product p = new Product();
		p = em.find(Product.class, id);
		em.remove(p);
		
	}

	@Override
	public List<Product> getAllProduct() {
		TypedQuery<Product> query = em.createQuery("select p from Product p ",Product.class);
		return query.getResultList();
	}

	@Override
	public int DeadlinePromotion(int productId) {
		 Query query = em.createQuery("UPDATE Product SET dateFinPromotion = null , promotion = 0 where productId=:productId");
	query.setParameter("productId", productId);
	int count = query.executeUpdate();
	return count ;
	
	}

}
