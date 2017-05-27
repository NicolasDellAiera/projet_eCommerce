package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Role;

public interface IAdminService {
	
	public List<Admin> getAllAdminProd();
	public Admin createAdminProd(Admin ad);
	public Role linkAdminRole(long id);
	public Admin updateAdminProd(Admin ad);
	public Admin getAdminById(long id);
	public void deleteAdminProd(long id);

}