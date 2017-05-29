package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

/**
 * Cette classe de la couche SERVICE permet à un client du site e-commerce de gérer son compte
 * La méthode editCLient(Client c) lui permet soit de créer un compte, soit de le modifier s'il en a déjà un.
 * La méthode isExist(Client c) permet de vérifier, lorsqu'un client se connecte, qu'il existe bien dans la base de données
 * @author Nicolas Dell'Aiera
 *
 */

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService 
{
	
	/**
	 * Insertion de la DAO
	 */
	
	@Autowired
	private IClientDao clDAO;

	/**
	 * @return the clDAO
	 */
	public IClientDao getClDAO() {
		return clDAO;
	}

	/**
	 * @param clDAO the clDAO to set
	 */
	public void setClDAO(IClientDao clDAO) {
		this.clDAO = clDAO;
	}
	
	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */

	@Override
	public Client isExist(Client c) 
	{
		return clDAO.isExist(c);
	}

	@Override
	public Client editClient(Client c) 
	{	
		return clDAO.editClient(c);
	}

}
