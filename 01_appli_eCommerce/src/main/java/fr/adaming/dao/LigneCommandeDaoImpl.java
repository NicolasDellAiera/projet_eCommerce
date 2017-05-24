package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.LigneCommande;

@Repository

public class LigneCommandeDaoImpl implements ILigneCommandeDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<LigneCommande> getAllCommandLine() {
		Session s=sf.getCurrentSession();
		String req="from LigneCommange l";
		Query query=s.createQuery(req);
		List<LigneCommande> listeDesCommandes=query.list();
		return listeDesCommandes;
	}

	@Override
	public LigneCommande getCommandLineById(int id) {
		Session s=sf.getCurrentSession();
		LigneCommande l=(LigneCommande) s.get(LigneCommande.class, id);
		return l;
	}

	@Override
	public LigneCommande createCommandLine(LigneCommande l) {
		Session s=sf.getCurrentSession();
		s.save(l);
		return l;
	}

	@Override
	public LigneCommande updateCommandLine(LigneCommande l) {
		Session s=sf.getCurrentSession();
		LigneCommande l_find=(LigneCommande) s.get(LigneCommande.class, l.getIdLigneCommande());
		l_find=l;
		s.merge(l_find);
		return l;
	}

	@Override
	public int deleteCommandLine(int id) {
		Session s=sf.getCurrentSession();
		LigneCommande l_rem=(LigneCommande) s.get(LigneCommande.class, id);
		s.delete(l_rem);
		return 0;
	}

}