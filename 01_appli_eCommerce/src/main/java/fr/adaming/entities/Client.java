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
@Table(name="clients")

public class Client implements Serializable {
	
	//-----Attributes-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idClient")
	private long idClient;
	
	@Column(name="nomClient")
	private String nomClient;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tel")
	private String tel;
	
	//-----Associations-----//
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Commande> listeCommandes;
	
	//-----Constructeurs-----//
	
	public Client(){
	}

	public Client(String nomClient, String adresse, String email, String tel) {
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Client(long idClient, String nomClient, String adresse, String email, String tel) {
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	//-----Getetrs et Setters-----//
	
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	//-----Methode String-----//
	
	@Override
	public String toString() 
	{
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	
}