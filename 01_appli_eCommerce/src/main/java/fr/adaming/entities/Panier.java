package fr.adaming.entities;

import java.util.ArrayList;
import java.util.List;

public class Panier 
{
	//Associations
	List<LigneCommande> listeLignesCommande = new ArrayList<LigneCommande>();
	
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
	
}
