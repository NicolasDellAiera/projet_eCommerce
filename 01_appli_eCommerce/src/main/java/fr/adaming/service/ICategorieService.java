package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;

public interface ICategorieService 
{
	public List<Categorie> getAllCategory();
	public Categorie getCategorieByID(int id);
	public Categorie getCategorieByName(String nom);
	public Categorie createCategory(Categorie cat);
	public void deleteCategorie(int id);
	public Categorie updateCategory(Categorie cat);
}