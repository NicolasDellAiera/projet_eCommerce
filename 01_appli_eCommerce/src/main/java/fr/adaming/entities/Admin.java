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
@Table(name="admins")

public class Admin implements Serializable {
	
	//-----Attributes-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAdmin")
	private long idAdmin;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="activated")
	private boolean activated;
	
	//-----Associations-----//
	
	@OneToMany(mappedBy="admin", cascade=CascadeType.ALL)
	private List<Role> listeRoles;
	
	//-----Constructeurs-----//

	/**
	 * 
	 */
	public Admin() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param activated
	 */
	public Admin(String username, String password, boolean activated) {
		super();
		this.username = username;
		this.password = password;
		this.activated = activated;
	}

	/**
	 * @param idAdmin
	 * @param username
	 * @param password
	 * @param activated
	 */
	public Admin(long idAdmin, String username, String password, boolean activated) {
		super();
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
		this.activated = activated;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the idAdmin
	 */
	public long getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * @return the listeRoles
	 */
	public List<Role> getListeRoles() {
		return listeRoles;
	}

	/**
	 * @param listeRoles the listeRoles to set
	 */
	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", username=" + username + ", password=" + password + ", activated="
				+ activated + "]";
	}	

}