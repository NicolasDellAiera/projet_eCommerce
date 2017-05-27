package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="admin_id", referencedColumnName="idAdmin")
	private Admin admin;
	
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
	
	//-----Getters et Setters-----//

	/**
	 * @return the idRole
	 */
	public long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + "]";
	}

}