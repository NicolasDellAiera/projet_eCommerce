package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Classe service implémentant l'interface pour les méthodes de l'administrateur
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminProdDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

@Service
@Transactional

public class AdminServiceImpl implements IAdminService {
	
	/**
	 * Insertion de la DAO
	 */
	
	@Autowired
	private IAdminProdDao admDAO;

	/**
	 * @return the admDAO
	 */
	public IAdminProdDao getAdmDAO() {
		return admDAO;
	}

	/**
	 * @param admDAO the admDAO to set
	 */
	public void setAdmDAO(IAdminProdDao admDAO) {
		this.admDAO = admDAO;
	}
	
	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */

	@Override
	public List<Admin> getAllAdminProd() {
		return admDAO.getAllAdminProd();
	}

	@Override
	public Admin createAdminProd(Admin ad) {
		return admDAO.createAdminProd(ad);
	}

	@Override
	public Role linkAdminRole(long id) {
		return admDAO.linkAdminRole(id);
	}

	@Override
	public Admin updateAdminProd(Admin ad) {
		return admDAO.updateAdminProd(ad);
	}

	@Override
	public Admin getAdminById(long id) {
		return admDAO.getAdminById(id);
	}

	@Override
	public void deleteAdminProd(long id) {
		admDAO.deleteAdminProd(id);
	}

}