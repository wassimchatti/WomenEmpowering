package tn.EW.womenEmpowering.services;

import java.util.List;

import javax.ejb.Remote;

import tn.EW.womenEmpowering.entityProduit.CategorieProduct;



@Remote
public interface categorieServiceRemote {
	public void addCategorie(CategorieProduct categorie);
	public void updateCategorie(CategorieProduct categorie);
	public void deleteCategorie (int id);
	public List<CategorieProduct> getAllCategorie();
	public List<CategorieProduct> getAllCategoriebyname();
	public CategorieProduct getAllCategoriebyname(String nameCategorie);
	public CategorieProduct getAllCategoriebyId(int id);
	
}
