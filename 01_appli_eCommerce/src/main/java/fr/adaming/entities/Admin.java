package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	//-----Associations-----//
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="idRole")
	private Role role;
	
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
	 */
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @param idAdmin
	 * @param username
	 * @param password
	 */
	public Admin(long idAdmin, String username, String password) {
		super();
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
	}	

}