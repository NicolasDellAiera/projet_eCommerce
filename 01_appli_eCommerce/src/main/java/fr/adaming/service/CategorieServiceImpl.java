package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.entities.Categorie;

@Service("catService")
@Transactional

public class CategorieServiceImpl implements ICategorieService 
{
	//Associations
	@Autowired
	private ICategorieDao catDAO;

	public ICategorieDao getCatDAO() {
		return catDAO;
	}
	
	//Getters and setters
	public void setCatDAO(ICategorieDao catDAO) {
		this.catDAO = catDAO;
	}
	
	//Methods
	@Override
	public List<Categorie> getAllCategory() {
		return catDAO.getAllCategory();
	}

	@Override
	public Categorie getCategorieByName(String name) {
		return catDAO.getCategorieByName(name);
	}

}