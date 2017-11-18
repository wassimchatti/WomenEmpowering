package tn.EW.womenEmpowering.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.EW.womenEmpowering.entityProduit.FavorisProduct;

@Remote
public interface favorisServiceRemote {

	public void AddFavoris(int idP , int idU , Date date);
	public void AnnulerFavoris(int idProduct , int idUser);
	public List<String> getAllFavoris();
	public FavorisProduct getAllFavorisExist(int idP , int idU);
}
