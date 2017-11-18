package tn.EW.womenEmpowering.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.EW.womenEmpowering.entityProduit.Utilisateur;


@Stateless
@LocalBean
public class utilisateurService implements utilisateurServiceRemote {

	@PersistenceContext(unitName="womenEmpowering-ejb")
	EntityManager em;
	@Override
	public int AddUser(Utilisateur u) {
		em.persist(u);
		return u.getId();
	}

	@Override
	public void UpdateUser(Utilisateur u) {
		em.merge(u);
		
	}

	@Override
	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		user = em.find(Utilisateur.class, id);
		em.remove(user);
	}

	@Override
	public Utilisateur getUtilisateurByEmailAndPassword(String email, String password) {
		TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e"
				+" where e.adresseMail 	=:email and e.password =:password "
				,Utilisateur.class);
					query.setParameter("email",email);
					query.setParameter("password",password);
				
					Utilisateur user = null; 
					try{
						user = query.getSingleResult();
					}catch(NoResultException e){
						System.out.println("Aucun info");	
					}

					return user;
	}

	@Override
	public Utilisateur getIdAdmin() {
		// TODO Auto-generated method stub
		TypedQuery<Utilisateur> var =em.createQuery("Select e from Utilisateur e where role = Admin",Utilisateur.class);
		return var.getSingleResult() ;
	}

}
