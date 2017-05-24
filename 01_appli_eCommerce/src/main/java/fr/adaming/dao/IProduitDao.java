package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IProduitDao {
	
	public List<Produit> getAllProducts();
	
	public List<Produit> getAllProductsByCategory(Categorie c);
	
	public List<Produit> getAllProductsByKeyWord(String keyWord);
	
	public Produit getProduct(int id);

}