package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IProduitService {
	
	public List<Produit> getAllProductsByCategory(Categorie c);
	
	public List<Produit> getAllProductsByKeyWord(String keyWord);
	
	public Produit getProduct(int id);

}