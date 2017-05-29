package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

/**
 * Cette classe de la couche SERVICE permet � un client du site e-commerce de g�rer son compte
 * La m�thode editCLient(Client c) lui permet soit de cr�er un compte, soit de le modifier s'il en a d�j� un.
 * La m�thode isExist(Client c) permet de v�rifier, lorsqu'un client se connecte, qu'il existe bien dans la base de donn�es
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
