package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.LigneCommande;

public interface ILigneCommandeDao {
	
	public List<LigneCommande> getAllCommandLine();
	
	public LigneCommande getCommandLineById(int id);
	
	public LigneCommande createCommandLine(LigneCommande l);
	
	public LigneCommande updateCommandLine(LigneCommande l);
	
	public int deleteCommandLine(int id);

}