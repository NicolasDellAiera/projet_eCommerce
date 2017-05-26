package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.entities.Categorie;

@Service
@Transactional

public class CategorieServiceImpl implements ICategorieService 
{
	//Associations
	@Autowired
	private ICategorieDao catDAO;

	public ICategorieDao getCatDAO() {
		return catDAO;
	}
	
	public void setCatDAO(ICategorieDao catDAO) {
		this.catDAO = catDAO;
	}
	
	//Methods
	@Override
	public List<Categorie> getAllCategory() {
		return catDAO.getAllCategory();
	}

	@Override
	public Categorie getCategorieByID(int id) {
		return catDAO.getCategorieByID(id);
	}
	
	@Override
	public Categorie getCategorieByName(String nom) {
		return catDAO.getCategorieByName(nom);
	}

	@Override
	public Categorie createCategory(Categorie cat) {
		return catDAO.createCategory(cat);
	}

	@Override
	public void deleteCategorie(int id) {
		catDAO.deleteCategorie(id);
	}

	@Override
	public Categorie updateCategory(Categorie cat) {
		return catDAO.updateCategory(cat);
	}

}