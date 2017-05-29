package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les lignes de commande
 */

import java.util.List;

import fr.adaming.entities.LigneCommande;

public interface ILigneCommandeDao {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes LigneCommande dans la DAO
	 */
	
	public List<LigneCommande> getAllCommandLine();
	
	public LigneCommande getCommandLineById(int id);
	
	public LigneCommande createCommandLine(LigneCommande l);
	
	public LigneCommande updateCommandLine(LigneCommande l);
	
	public int deleteCommandLine(int id);

}