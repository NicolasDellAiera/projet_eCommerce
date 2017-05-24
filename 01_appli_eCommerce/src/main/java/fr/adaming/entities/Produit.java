package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produits")

public class Produit implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProduit")
	private int idProduit;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="description")
	private String description;
	
	@Column(name="prix")
	private double prix;
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="selection")
	private boolean selection;
	
	@Column(name="photo")
	private String photo;
	
	//-----Associations-----//
	
	@OneToMany(mappedBy="produit", cascade=CascadeType.ALL)
	private List<LigneCommande> listeLigneCommandes;
	
	//-----Constructeurs-----//

	public Produit() {
		super();
	}

	public Produit(String designation, String description, double prix, int quantite, boolean selection, String photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
		this.photo = photo;
	}

	public Produit(int idProduit, String designation, String description, double prix, int quantite, boolean selection,
			String photo) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
		this.photo = photo;
	}
	
	//-----Getetrs et Setters-----//

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<LigneCommande> getListeLigneCommandes() {
		return listeLigneCommandes;
	}

	public void setListeLigneCommandes(List<LigneCommande> listeLigneCommandes) {
		this.listeLigneCommandes = listeLigneCommandes;
	}
	
	//-----Methode String-----//

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", quantite=" + quantite + ", selection=" + selection + ", photo=" + photo
				+ ", listeLigneCommandes=" + listeLigneCommandes + "]";
	}

}