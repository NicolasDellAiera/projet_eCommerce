package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Interface du service pour les lignes de commandes
 */

import java.util.List;

import fr.adaming.entities.LigneCommande;

public interface ILigneCommandeService {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes ligne de commandes dans le service
	 */
	
	public List<LigneCommande> getAllCommandLine();
	
	public LigneCommande getCommandLineById(int id);
	
	public LigneCommande createCommandLine(LigneCommande l);
	
	public LigneCommande updateCommandLine(LigneCommande l);
	
	public int deleteCommandLine(int id);


}