package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;

/**
 * Cette classe de la couche DAO permet à un client du site e-commerce de gérer son compte
 * La méthode editCLient(Client c) lui permet soit de créer un compte, soit de le modifier s'il en a déjà un.
 * La méthode isExist(Client c) permet de vérifier, lorsqu'un client se connecte, qu'il existe bien dans la base de données
 * @author Nicolas Dell'Aiera
 *
 */

@Repository
public class ClientDaoImpl implements IClientDao 
{
	//Attributes
	@Autowired
	private SessionFactory sf;

	//Getters and setters
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	//Methods
	@Override
	public Client isExist(Client c) 
	{
		Session s=sf.getCurrentSession();
		String req="from Client as c where c.email=:pEmail and c.mdp=:pMDP";
		Query query=s.createQuery(req);
		query.setParameter("pEmail", c.getEmail());
		query.setParameter("pMDP", c.getMdp());
		Client c_rec=(Client) query.uniqueResult();
		return c_rec;
	}

	@Override
	public Client editClient(Client c) 
	{
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(c);
		return c;
	}

}