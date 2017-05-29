package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les commandes
 */

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

public interface ICommandeDao {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes Commandes dans la DAO
	 */
	
	public List<Commande> getAllCommand(Client cl);
	
	public Commande createCommand(Commande c);

}