package fr.adaming.service;

/**
 * @author INTI-0366
 * 
 * Interface du service pour les administrateurs
 */

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

public interface IAdminService {
	
	/**
	 * @return
	 * 
	 * Initialisation des méthodes Admin dans le service
	 */
	
	public List<Admin> getAllAdminProd();
	public Admin createAdminProd(Admin ad);
	public Role linkAdminRole(long id);
	public Admin updateAdminProd(Admin ad);
	public Admin getAdminById(long id);
	public void deleteAdminProd(long id);

}