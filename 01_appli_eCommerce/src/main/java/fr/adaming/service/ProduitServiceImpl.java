package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Classe service implémentant l'interface pour les méthodes de les produits
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Service("prService")
@Transactional

public class ProduitServiceImpl implements IProduitService {
	
	/**
	 * Insertion de la DAO
	 */
	
	@Autowired
	private IProduitDao prDAO;

	/**
	 * @return the prDAO
	 */
	public IProduitDao getPrDAO() {
		return prDAO;
	}

	/**
	 * @param prDAO the prDAO to set
	 */
	public void setPrDAO(IProduitDao prDAO) {
		this.prDAO = prDAO;
	}
	
	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */

	@Override
	public List<Produit> getAllProductsByCategory(Categorie c) {
		return prDAO.getAllProductsByCategory(c);
	}

	@Override
	public List<Produit> getAllProductsByKeyWord(String keyWord) {
		return prDAO.getAllProductsByKeyWord(keyWord);
	}

	@Override
	public Produit getProduct(int id) {
		return prDAO.getProduct(id);
	}

	@Override
	public List<Produit> getAllProducts() {
		return prDAO.getAllProducts();
	}

	@Override
	public Produit createProduct(Produit p) {
		return prDAO.createProduct(p);
	}

	@Override
	public Produit updateProduct(Produit p) {
		return prDAO.updateProduct(p);
	}

	@Override
	public void deleteProduct(int id) {
		prDAO.deleteProduct(id);
	}

}
