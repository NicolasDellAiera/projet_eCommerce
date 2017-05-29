package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Interface du service pour les clients
 */

import fr.adaming.entities.Client;

public interface IClientService 
{
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes clients dans le service
	 */
	
	public Client isExist(Client c);
	public Client editClient(Client c);
}