package tn.EW.womenEmpowering.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.EW.womenEmpowering.entityProduit.CommentProduct;
import tn.EW.womenEmpowering.entityProduit.CommentProductPK;

import tn.EW.womenEmpowering.entityProduit.Product;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;

@LocalBean
@Stateless
public class commentService implements commentServiceRemote {
	@PersistenceContext(unitName="womenEmpowering-ejb")
	EntityManager em;
	@Override
	public void AddComment(int idP, int idU, Date date,String comment) {
		Product produitManagedEntity = em.find(Product.class, idP);
		Utilisateur userManagedEntity = em.find(Utilisateur.class, idU);
		 
		CommentProductPK  cpk =new CommentProductPK();
		cpk.setIdProduct(idP);
		cpk.setIdUser(idU);
		cpk.setDateComment(date);
		
		
	
		
		CommentProduct cp = new CommentProduct();
		cp.setProduit(produitManagedEntity);
		cp.setUser(userManagedEntity);
		cp.setCommentproductPK(cpk);
		
		
		cp.setNomComment(comment);;
		
		em.persist(cp);
		
	}

	@Override
	public void DeleteComment(int idC) {
		CommentProduct cp =new CommentProduct();
		cp = em.find(CommentProduct.class, idC);
		em.remove(cp);
				
		
	}

	@Override
	public List<CommentProduct> getAllComment() {
		TypedQuery<CommentProduct> query = em.createQuery("select c from CommentProduct c ",CommentProduct.class);
		return query.getResultList();
	}

	@Override
	public List<CommentProduct> getAllComment(int idProduct) {
//		TypedQuery<CommentProductPK> query =em.createQuery("Select a from CommentProduct a where a.idProduct =: idProduct",CommentProductPK.class);
//		query.setParameter("idProduct",idProduct);
//		List<CommentProduct> l = new ArrayList<>();
//			
//		l = (List<CommentProduct>) query ;
//		
//		return ((Query) l).getResultList();
		return null;
	}

}
