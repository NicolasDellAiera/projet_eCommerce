package fr.adaming.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class Panier 
{
	//Associations
	@Transient
	List<LigneCommande> listeLignesCommande = new ArrayList<LigneCommande>();
	
	//Attributes
	@Transient
	double montant = 0;
	
	//Constructor
	public Panier(){
	}

	//Getters and setters
	public List<LigneCommande> getListeLignesCommande() {
		return listeLignesCommande;
	}
	public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
		this.listeLignesCommande = listeLignesCommande;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
}
