package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ligneCommandes")

public class LigneCommande implements Serializable {
	
	//-----Attributs-----//

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLigneCommande")
	private int idLigneCommande;
	
	@Column(name="quantite")
	@Range(min=1, message="Il n''est pas possible de commander moins de 1 produit")
	private int quantite;
	
	@Column(name="prix")
	private double prix;
	
	//-----Associations-----//
	
	@ManyToOne
	@JoinColumn(name="commande_id", referencedColumnName="idCommande")
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name="produit_id", referencedColumnName="idProduit")
	private Produit produit;
	
	//-----Constructeurs-----//

	public LigneCommande() {
		super();
	}

	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public LigneCommande(int idLigneCommande, int quantite, double prix) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	//-----Getetrs et Setters-----//

	public int getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	//-----Methode String-----//

	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix + "]";
	}

}