package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les categories
 */

import java.util.List;

import fr.adaming.entities.Categorie;

public interface ICategorieDao
{
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes Categorie dans la DAO
	 */
	
	public List<Categorie> getAllCategory();
	public Categorie getCategorieByID(int id);
	public Categorie getCategorieByName(String nom);
	public Categorie createCategory(Categorie cat);
	public void deleteCategorie(int id);
	public Categorie updateCategory(Categorie cat);
}