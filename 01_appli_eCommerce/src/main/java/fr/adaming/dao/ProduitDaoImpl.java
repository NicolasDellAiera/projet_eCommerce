package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Classe DAO implémentant l'interface pour les méthodes des produits
 */

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Repository

public class ProduitDaoImpl implements IProduitDao {
	
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
	public List<Produit> getAllProductsByCategory(Categorie c) {
		Session s=sf.getCurrentSession();
		String req="FROM Produit p WHERE p.categorie.nomCategorie=:pCategorie ORDER BY p.designation ASC";
		Query query=s.createQuery(req);
		query.setParameter("pCategorie", c.getNomCategorie());
		List<Produit> listeProduitsParCategorie=query.list();
		return listeProduitsParCategorie;
	}

	@Override
	public List<Produit> getAllProductsByKeyWord(String keyWord) {
		Session s=sf.getCurrentSession();
		
		Criteria cr1=s.createCriteria(Produit.class);
		cr1.add(Restrictions.like("designation", "%" + keyWord + "%"));
		List<Produit> listeProduitParNom=cr1.list();
		
		Criteria cr2=s.createCriteria(Produit.class);
		cr2.add(Restrictions.like("description", "%" + keyWord + "%"));
		List<Produit> listeProduitParMotCle=cr2.list();
		
		System.out.println("--------liste1 " + listeProduitParNom);
		System.out.println("--------liste2 " + listeProduitParMotCle);
		
		List<Produit> listeProduits=new ArrayList<Produit>();
		
		int i=0;
		int j=0;
		
		if(listeProduitParNom!=null)
		{
			for (Produit P1:listeProduitParNom) {
				listeProduits.add(listeProduitParNom.get(i));
				i++;
			}
		}
		
		if(listeProduitParMotCle!=null)
		{
			for (Produit P2:listeProduitParMotCle) {
				listeProduits.add(listeProduitParMotCle.get(j));
				j++;
			}
		}
		
		return listeProduits;
	}

	@Override
	public Produit getProduct(int id) {
		Session s=sf.getCurrentSession();
		Produit p=(Produit) s.get(Produit.class, id);
		return p;
	}

	@Override
	public List<Produit> getAllProducts() {
		Session s=sf.getCurrentSession();
		String req="FROM Produit p ORDER BY p.designation ASC";
		Query query=s.createQuery(req);
		List<Produit> listeProduits=query.list();
		return listeProduits;
	}

	@Override
	@Transactional(readOnly = false)
	public Produit createProduct(Produit p) {
		Session s = sf.openSession();
		s.save(p);
		return p;
	}

	@Override
	public Produit updateProduct(Produit p) {
		Session s = sf.getCurrentSession();
		Produit p_find=(Produit) s.get(Produit.class, p.getIdProduit());
		p_find=p;
		s.merge(p_find);
		return p;
	}

	@Override
	public void deleteProduct(int id) {
		Session s = sf.getCurrentSession();
		Produit p_rem=(Produit) s.get(Produit.class, id);
		s.delete(p_rem);
	}

}