package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

public interface ICommandeService {
	
	public List<Commande> getAllCommand(Client cl);
	
	public Commande createCommand(Commande c);

}
