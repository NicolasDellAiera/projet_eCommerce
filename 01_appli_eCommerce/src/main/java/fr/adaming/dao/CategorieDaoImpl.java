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
	public Categorie getCategorieByID(int id) {
		Session s = sf.openSession();
		Categorie cat=(Categorie) s.get(Categorie.class, id);
		return cat;
	}
	
	@Override
	public Categorie getCategorieByName(String nom) {
		Session s = sf.openSession();
		String req="FROM Categorie c WHERE c.nomCategorie=:pCategorie";
		Query query=s.createQuery(req);
		query.setParameter("pCategorie", nom);
		Categorie cat=(Categorie) query.uniqueResult();
		return cat;
	}

	@Override
	public Categorie createCategory(Categorie cat) {
		Session s = sf.openSession();
		s.save(cat);
		return cat;
	}

	@Override
	public void deleteCategorie(int id) {
		Session s = sf.getCurrentSession();
		Categorie cat_rem=(Categorie) s.get(Categorie.class, id);
		s.delete(cat_rem);
	}

	@Override
	public Categorie updateCategory(Categorie cat) {
		Session s = sf.getCurrentSession();
		Categorie cat_find=(Categorie) s.get(Categorie.class, cat.getIdCategorie());
		cat_find=cat;
		s.merge(cat_find);
		return cat;
	}

}