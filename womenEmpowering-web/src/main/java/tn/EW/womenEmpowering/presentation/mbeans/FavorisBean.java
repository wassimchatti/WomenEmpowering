package tn.EW.womenEmpowering.presentation.mbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.EW.womenEmpowering.services.favorisService;

@ManagedBean
@SessionScoped
public class FavorisBean {

	private Date date ;
	private Integer selectedUserId;
	private Integer selectedProductId;
	
	@EJB
	favorisService fs;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(Integer selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public Integer getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(Integer selectedProductId) {
		this.selectedProductId = selectedProductId;
	}
	
	@PostConstruct
	public void init(){
		date = new Date();
		
	}
	
	
	
	
}
