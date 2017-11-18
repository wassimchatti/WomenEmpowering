package tn.EW.womenEmpowering.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.EW.womenEmpowering.entityProduit.Role;



@ManagedBean
@ApplicationScoped
public class DataRole {
	public Role[] getRoles(){
		return Role.values();
		}
	
}
