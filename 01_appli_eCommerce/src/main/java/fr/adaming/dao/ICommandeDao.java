package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

public interface ICommandeDao {
	
	public List<Commande> getAllCommand(Client cl);
	
	public Commande createCommand(Commande c);

}