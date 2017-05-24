package fr.adaming.service;

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
	
	@Autowired
	private IProduitDao prDAO;

	public IProduitDao getPrDAO() {
		return prDAO;
	}

	public void setPrDAO(IProduitDao prDAO) {
		this.prDAO = prDAO;
	}

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

}
