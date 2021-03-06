package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les produits
 */

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IProduitDao {
	
	/**
	 * @return
	 * 
	 * Initialisation des m�thodes Produits dans la DAO
	 */
	
	public List<Produit> getAllProducts();
	
	public List<Produit> getAllProductsByCategory(Categorie c);
	
	public List<Produit> getAllProductsByKeyWord(String keyWord);
	
	public Produit getProduct(int id);
	
	public Produit createProduct(Produit p);
	
	public Produit updateProduct(Produit p);
	
	public void deleteProduct(int id);

}