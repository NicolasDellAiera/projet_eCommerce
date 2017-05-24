package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;

@Repository

public class ClientDaoImpl implements IClientDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client isExist(Client c) {
		Session s=sf.getCurrentSession();
		String req="from Client as c where c.email=:pEmail and c.mdp=:pMDP";
		Query query=s.createQuery(req);
		query.setParameter("pEmail", c.getEmail());
		query.setParameter("pMDP", c.getMdp());
		Client c_rec=(Client) query.uniqueResult();
		return c_rec;
	}

}