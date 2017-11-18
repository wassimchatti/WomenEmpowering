package tn.EW.womenEmpowering.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.EW.womenEmpowering.entityProduit.CategorieProduct;


@LocalBean
@Stateless
public class categorieService implements categorieServiceRemote {
	@PersistenceContext(unitName="womenEmpowering-ejb")
	EntityManager em;
	
	@Override
	public void addCategorie(CategorieProduct categorie) {
		em.persist(categorie);
		
	}

	@Override
	public void updateCategorie(CategorieProduct categorie) {
		em.merge(categorie);
		
	}

	@Override
	public void deleteCategorie(int id) {
		CategorieProduct categorie = new CategorieProduct();
	     categorie = em.find(CategorieProduct.class, id);
	     em.remove(categorie);
		
	}

	@Override
	public List<CategorieProduct> getAllCategorie() {
		TypedQuery<CategorieProduct> query = em.createQuery("select c from CategorieProduct c ",CategorieProduct.class );
		return query.getResultList();
	}

	@Override
	public List<CategorieProduct> getAllCategoriebyname() {
		TypedQuery<CategorieProduct> query = em.createQuery("select c.nameCategorie from CategorieProduct c ",CategorieProduct.class );
		return query.getResultList();
	}

	@Override
	public CategorieProduct getAllCategoriebyname(String nameCategorie) {
		TypedQuery<CategorieProduct> query = em.createQuery("select c from CategorieProduct c where nameCategorie =:nameCategorie ",CategorieProduct.class );
		query.setParameter("nameCategorie",nameCategorie);
		CategorieProduct cat = null; 
		try{
			cat = query.getSingleResult();
		}catch(NoResultException e){
			System.out.println("Aucun info");	
		}

		return  cat;
	}

	@Override
	public CategorieProduct getAllCategoriebyId(int id) {
		CategorieProduct ct = em.find(CategorieProduct.class, id);
		return ct;
	}

}
