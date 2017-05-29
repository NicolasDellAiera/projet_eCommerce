package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Interface du service pour les categories
 */

import java.util.List;

import fr.adaming.entities.Categorie;

public interface ICategorieService 
{
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes categories dans le service
	 */
	
	public List<Categorie> getAllCategory();
	public Categorie getCategorieByID(int id);
	public Categorie getCategorieByName(String nom);
	public Categorie createCategory(Categorie cat);
	public void deleteCategorie(int id);
	public Categorie updateCategory(Categorie cat);
}