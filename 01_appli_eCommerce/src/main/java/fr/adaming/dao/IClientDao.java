package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les clients
 */

import fr.adaming.entities.Client;

public interface IClientDao 
{
	
	/**
	 * @return
	 * 
	 * Initialisation des m�thodes Client dans la DAO
	 */
	
	public Client isExist(Client c);
	public Client editClient(Client c);
}
