package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Annee")
public class Annee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7728252823874701320L;

	@Id
	@Column(name="annee")
	private int annee;
	
	//constructeurs
	
	public Annee() {
		
	}
	
	public Annee(int annee) {
		this.annee = annee;
	}
	
	//getter
	public int getAnnee() {
		return this.annee;
	}
	
	//setter
	public void setAnnee(int annee) {
		this.annee = annee;
	}
}
