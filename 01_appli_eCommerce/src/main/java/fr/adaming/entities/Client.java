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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="clients")

public class Client implements Serializable {
	
	//-----Attributes-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idClient")
	private long idClient;
	
	@Column(name="nomClient")
	@NotEmpty(message="Veuillez renseigner votre nom svp")
	private String nomClient;
	
	@Column(name="adresse")
	@NotEmpty(message="Veuillez renseigner votre adresse svp")
	private String adresse;
	
	@Column(name="email")
	@NotEmpty(message="Veuillez renseigner votre adresse mail svp")
	@Email(message="Adresse email non valide")
	private String email;
	
	@Column(name="mdp")
	@Length(min=5, message="Mot de passe invalide, il doit �tre compos� d''au moins 5 caract�res")
	private String mdp;
	
	@Column(name="tel")
	private String tel;
	
	//-----Associations-----//
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Commande> listeCommandes;
	
	//-----Constructeurs-----//
	
	public Client(){
	}

	public Client(String nomClient, String adresse, String email, String mdp, String tel) {
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	}

	public Client(long idClient, String nomClient, String adresse, String email,  String mdp, String tel) {
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", mdp=" + mdp + ", tel=" + tel + "]";
	}
	
}