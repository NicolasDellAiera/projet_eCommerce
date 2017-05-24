package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		Session s=sf.getCurrentSession();
		
		Criteria cr1=s.createCriteria(Produit.class);
		cr1.add(Restrictions.eq("designation", "%" + keyWord + "%"));
		List<Produit> listeProduitParNom=cr1.list();
		
		Criteria cr2=s.createCriteria(Produit.class);
		cr2.add(Restrictions.eq("description", "%" + keyWord + "%"));
		List<Produit> listeProduitParMotCle=cr2.list();
		
		List<Produit> listeProduits=new ArrayList<Produit>();
		
		int i=0;
		int j=0;
		
		for (Produit P1:listeProduitParNom) {
			listeProduits.add(listeProduitParNom.get(i));
			i++;
		}
		for (Produit P2:listeProduitParMotCle) {
			listeProduits.add(listeProduitParMotCle.get(j));
			i++;
		}
		
		return listeProduitParMotCle;
	}

	@Override
	public Produit getProduct(int id) {
		Session s=sf.getCurrentSession();
		Produit p=(Produit) s.get(Produit.class, id);
		return null;
	}

	@Override
	public List<Produit> getAllProducts() {
		Session s=sf.getCurrentSession();
		String req="from Produit p";
		Query query=s.createQuery(req);
		List<Produit> listeProduits=query.list();
		return listeProduits;
	}

}