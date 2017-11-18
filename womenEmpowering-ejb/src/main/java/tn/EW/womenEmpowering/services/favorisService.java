package tn.EW.womenEmpowering.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import tn.EW.womenEmpowering.entityProduit.FavorisProduct;
import tn.EW.womenEmpowering.entityProduit.Product;
import tn.EW.womenEmpowering.entityProduit.Utilisateur;


@LocalBean
@Stateless
public class favorisService implements favorisServiceRemote {
	@PersistenceContext(unitName="womenEmpowering-ejb")
	EntityManager em;
	
	@Override
	public void AddFavoris(int idP , int idU ,Date date) {
		Product produitManagedEntity = new Product();
		Utilisateur userManagedEntity = new Utilisateur();
		
		produitManagedEntity.setProductId(idP);
		userManagedEntity.setId(idU);
		
		FavorisProduct fp = new FavorisProduct();
		fp.setProduit(produitManagedEntity);
		fp.setUser(userManagedEntity);
		fp.setDateFavoris(date);
		
		
		
		System.out.println("testtttttttttttttttttttttttt :  "+fp.getProduit().getProductId()+" user : "+fp.getUser().getId());
		em.persist(fp);
		System.out.println("testtttttttttttttttttttttttt2 :   "+fp.getProduit().getProductId()+" user : "+fp.getUser().getId());

	}

	@Override
	public void AnnulerFavoris(int idProduct , int idUser) {
		// TODO Auto-generated method stub
		 Query query = em.createQuery("DELETE FROM FavorisProduct where idProduct=:idProduct and idUser=:idUser");
			query.setParameter("idProduct", idProduct);
			query.setParameter("idUser", idUser);
			int deleted = query.executeUpdate();
		
	}

	@Override
	public List<String> getAllFavoris() {
		List<String> list =em.createQuery("select e.nameProduct , e.priceProduct,e.promotion,e.quantite from Product e, FavorisProduct f where e.productId=f.idProduct  ",
				String.class).getResultList();
		return list;
	}

	@Override
	public FavorisProduct getAllFavorisExist(int idP , int idU) {
		javax.persistence.TypedQuery<FavorisProduct> query = em.createQuery("select e.produit ,e.user FROM FavorisProduct e where e.produit =:idP and e.user=:idU ",FavorisProduct.class);
		
		query.setParameter("idP",idP);
		query.setParameter("idU",idU);
		FavorisProduct favoris = null; 
		try{
			favoris = query.getSingleResult();
		}catch(NoResultException e){
			System.out.println("Aucune donnees pour ce favoris ......");	
		}

		return favoris;
	}

}
