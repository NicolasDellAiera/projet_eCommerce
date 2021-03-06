package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Classe DAO impl�mentant l'interface pour les m�thodes du client
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;

/**
 * Cette classe de la couche DAO permet � un client du site e-commerce de g�rer son compte
 * La m�thode editCLient(Client c) lui permet soit de cr�er un compte, soit de le modifier s'il en a d�j� un.
 * La m�thode isExist(Client c) permet de v�rifier, lorsqu'un client se connecte, qu'il existe bien dans la base de donn�es
 * @author Nicolas Dell'Aiera
 *
 */

@Repository
public class ClientDaoImpl implements IClientDao 
{
	
	/**
	 * Insertion de SessionFactory
	 */
	
	@Autowired
	private SessionFactory sf;

	/**
	 * @return the sf
	 */
	public SessionFactory getSf() {
		return sf;
	}

	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
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