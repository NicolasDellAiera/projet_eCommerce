package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")

public class Role implements Serializable {
	
	//-----Attributes-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRole")
	private long idRole;
	
	@Column(name="role")
	private String role;
	
	//-----Associations-----//
	
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private List<Admin> listeAdmins;
	
	//-----Constructeurs-----//

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param role
	 */
	public Role(String role) {
		super();
		this.role = role;
	}

	/**
	 * @param idRole
	 * @param role
	 */
	public Role(long idRole, String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}

}