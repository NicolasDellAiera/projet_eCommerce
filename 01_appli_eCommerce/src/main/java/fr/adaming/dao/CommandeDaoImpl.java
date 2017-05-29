package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Classe DAO implémentant l'interface pour les méthodes des commandes
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

@Repository

public class CommandeDaoImpl implements ICommandeDao {
	
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
	public List<Commande> getAllCommand(Client cl) {
		Session s=sf.getCurrentSession();
		String req="from Commande c where c.client.idCLient=:pIDcl";
		Query query=s.createQuery(req);
		query.setParameter("pIDcl", cl.getIdClient());
		List<Commande> listeCommandes=query.list();
		return listeCommandes;
	}

	@Override
	public Commande createCommand(Commande c) {
		Session s=sf.getCurrentSession();
		s.save(c);
		return c;
	}

}