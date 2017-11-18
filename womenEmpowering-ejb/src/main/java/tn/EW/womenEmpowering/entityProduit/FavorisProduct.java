	package tn.EW.womenEmpowering.entityProduit;
	
	import java.io.Serializable;
	import java.util.Date;
	
	import javax.persistence.EmbeddedId;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	
	@Entity
	public class FavorisProduct implements Serializable {
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id ;
		private Date dateFavoris;
		
		@ManyToOne
		private Utilisateur user;
		
		@ManyToOne
		private Product produit ;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getDateFavoris() {
			return dateFavoris;
		}

		public void setDateFavoris(Date dateFavoris) {
			this.dateFavoris = dateFavoris;
		}

		public Utilisateur getUser() {
			return user;
		}

		public void setUser(Utilisateur user) {
			this.user = user;
		}

		public Product getProduit() {
			return produit;
		}

		public void setProduit(Product produit) {
			this.produit = produit;
		}

		public FavorisProduct() {
			super();
			// TODO Auto-generated constructor stub
		}

		public FavorisProduct(int id, Date dateFavoris, Utilisateur user, Product produit) {
			super();
			this.id = id;
			this.dateFavoris = dateFavoris;
			this.user = user;
			this.produit = produit;
		}

		public FavorisProduct(Date dateFavoris, Utilisateur user, Product produit) {
			super();
			this.dateFavoris = dateFavoris;
			this.user = user;
			this.produit = produit;
		}
		
		
		
		
		
	}
