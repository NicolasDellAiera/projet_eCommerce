package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Categorie;

public interface ICategorieDao
{
	public List<Categorie> getAllCategory();
	public Categorie getCategorieByID(int id);
	public Categorie getCategorieByName(String nom);
	public Categorie createCategory(Categorie cat);
	public void deleteCategorie(int id);
	public Categorie updateCategory(Categorie cat);
}