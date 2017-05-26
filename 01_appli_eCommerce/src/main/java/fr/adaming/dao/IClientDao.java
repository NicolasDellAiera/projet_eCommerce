package fr.adaming.dao;

import fr.adaming.entities.Client;

public interface IClientDao 
{
	public Client isExist(Client c);
	public Client editClient(Client c);
}
