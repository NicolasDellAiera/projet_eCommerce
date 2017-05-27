package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

public interface IAdminProdDao {
	
	public List<Admin> getAllAdminProd();
	public Admin createAdminProd(Admin ad);
	public Role linkAdminRole(long id);
	public Admin updateAdminProd(Admin ad);
	public void deleteAdminProd(long id);
	public Admin getAdminById(long id);

}