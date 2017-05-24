package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Repository

public class ProduitDaoImpl implements IProduitDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Produit> getAllProductsByCategory(Categorie c) {
		Session s=sf.getCurrentSession();
		String req="from Produit p where p.categorie.nomCategorie=:pCategorie";
		Query query=s.createQuery(req);
		query.setParameter("pCategorie", c.getNomCategorie());
		List<Produit> listeProduitsParCategorie=query.list();
		return listeProduitsParCategorie;
	}

	@Override
	public List<Produit> getAllProductsByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}