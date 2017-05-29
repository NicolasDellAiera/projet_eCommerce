package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Interface du service pour les commandes
 */

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

public interface ICommandeService {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes commandes dans le service
	 */
	
	public List<Commande> getAllCommand(Client cl);
	
	public Commande createCommand(Commande c);

}
