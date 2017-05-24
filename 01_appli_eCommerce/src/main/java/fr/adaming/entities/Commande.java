package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commande")

public class Commande implements Serializable {
	
	@Id
	private int idCommande;

}