package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")

public class Commande implements Serializable {
	
	//-----Attributs-----//

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCommande")
	private int idCommande;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateCommande")
	private Date dateCommande;
	
	//-----Associations-----//
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="idClient")
	private Client client;
	
	//-----Constructeurs-----//
	
	public Commande() {
		super();
	}
	
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}
	
	public Commande(int idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}
	
	//-----Getetrs et Setters-----//

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	//-----Methode String-----//

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}

}