package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Classe service implémentant l'interface pour les méthodes de les lignes de commandes
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

@Service("csService")
@Transactional

public class CommandeServiceImpl implements ICommandeService {
	
	/**
	 * Insertion de la DAO
	 */
	
	@Autowired
	private ICommandeDao csDAO;

	/**
	 * @return the csDAO
	 */
	public ICommandeDao getCsDAO() {
		return csDAO;
	}

	/**
	 * @param csDAO the csDAO to set
	 */
	public void setCsDAO(ICommandeDao csDAO) {
		this.csDAO = csDAO;
	}
	
	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */

	@Override
	public List<Commande> getAllCommand(Client cl) {
		return csDAO.getAllCommand(cl);
	}

	@Override
	public Commande createCommand(Commande c) {
		return csDAO.createCommand(c);
	}

}