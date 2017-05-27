package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Role;

@Repository

public class AdminProdDaoImpl implements IAdminProdDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Admin> getAllAdminProd() {
		Session s = sf.openSession();
		
		String req1="from Role r where r.role=:pRole";
		Query query1=s.createQuery(req1);
		query1.setParameter("pRole", "ROLE_ADMINPROD");
		List<Role> listeRoleAdmins=query1.list();
		
		List<Admin> listeAdminProds=new ArrayList<Admin>();
		int i=0;
		
		for(Role R:listeRoleAdmins) {
			Role r=listeRoleAdmins.get(i);
			String req2="from Admin a where a.idAdmin=:pId";
			Query query2=s.createQuery(req2);
			query2.setParameter("pId", r.getAdmin().getIdAdmin());
			Admin a=(Admin) query2.uniqueResult();
			listeAdminProds.add(a);
			i++;
		}
		
		return listeAdminProds;
	}

	@Override
	public Admin createAdminProd(Admin ad) {
		Session s = sf.openSession();
		s.save(ad);
		return ad;
	}
	
	@Override
	public Role linkAdminRole(long id) {
		Session s = sf.openSession();
		Admin ad_rec=(Admin) s.get(Admin.class, id);
		Role r=new Role();
		r.setRole("ROLE_ADMINPROD");
		r.setAdmin(ad_rec);
		s.save(r);
		return r;
	}

	@Override
	public Admin updateAdminProd(Admin ad) {
		Session s = sf.getCurrentSession();
		Admin ad_rec=(Admin) s.get(Admin.class, ad.getIdAdmin());
		ad_rec=ad;
		s.merge(ad_rec);
		return ad;
	}

	@Override
	public void deleteAdminProd(long id) {
		Session s = sf.getCurrentSession();
		Admin ad_rem=(Admin) s.get(Admin.class, id);
		s.delete(ad_rem);
		String req="delete from Role r where r.admin.idAdmin=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pId", id);
	}

	@Override
	public Admin getAdminById(long id) {
		Session s = sf.openSession();
		Admin ad=(Admin) s.get(Admin.class, id);
		return ad;
	}

}