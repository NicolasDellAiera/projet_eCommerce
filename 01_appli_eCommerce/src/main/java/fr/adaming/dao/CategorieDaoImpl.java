package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;

@Repository

public class CategorieDaoImpl implements ICategorieDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Categorie> getAllCategory() {
		Session s=sf.getCurrentSession();
		String req="from Categorie c";
		Query query=s.createQuery(req);
		List<Categorie> listeCategories=query.list();
		return listeCategories;
	}

	@Override
	public Categorie getCategorieByName(String name) {
		Session s = sf.openSession();
		String req="FROM Categorie c WHERE c.nomCategorie=:pNom";
		Query query = s.createQuery(req);
		query.setParameter("pNom", name);
		return (Categorie) query.uniqueResult();
	}

}