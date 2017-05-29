package fr.adaming.dao;

/**
 * @author INTI-0366
 * 
 * Interface de la DAO pour les administrateurs
 */

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

public interface IAdminProdDao {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes Admin dans la DAO
	 */
	
	public List<Admin> getAllAdminProd();
	public Admin createAdminProd(Admin ad);
	public Role linkAdminRole(long id);
	public Admin updateAdminProd(Admin ad);
	public void deleteAdminProd(long id);
	public Admin getAdminById(long id);

}