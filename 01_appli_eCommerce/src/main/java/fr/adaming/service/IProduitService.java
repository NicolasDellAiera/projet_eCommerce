package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IProduitService {
	
	public List<Produit> getAllProducts();
	
	public List<Produit> getAllProductsByCategory(Categorie c);
	
	public List<Produit> getAllProductsByKeyWord(String keyWord);
	
	public Produit getProduct(int id);
	
	public Produit createProduct(Produit p);
	
	public Produit updateProduct(Produit p);
	
	public void deleteProduct(int id);

}