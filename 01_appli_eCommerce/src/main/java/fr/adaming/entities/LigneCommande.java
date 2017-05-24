package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneCommandes")

public class LigneCommande implements Serializable {
	
	//-----Attributs-----//

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLigneCommande")
	private int idLigneCommande;
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="prix")
	private int prix;
	
	//-----Associations-----//
	
	@ManyToOne
	@JoinColumn(name="commande_id", referencedColumnName="idCommande")
	private Commande commande;
	
	//-----Constructeurs-----//

	public LigneCommande() {
		super();
	}

	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public LigneCommande(int idLigneCommande, int quantite, int prix) {
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
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