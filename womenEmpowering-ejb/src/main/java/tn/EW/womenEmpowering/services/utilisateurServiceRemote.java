package tn.EW.womenEmpowering.services;

import javax.ejb.Remote;

import tn.EW.womenEmpowering.entityProduit.Utilisateur;


@Remote
public interface utilisateurServiceRemote {
 
	public int AddUser(Utilisateur u);
	public void UpdateUser(Utilisateur u);
	public void DeleteUser(int id);
	public Utilisateur getUtilisateurByEmailAndPassword(String email, String password);
	public Utilisateur getIdAdmin ();
}
