package com.example.projetSI.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professeur")
public class Prof implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1810451212435414631L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prof", unique = true, nullable = false)
	private int id_prof;
	
	@Column(name = "nom")
	private String nom_prof;
	
	@Column(name = "prenom")
	private String prenom_prof;
	
	@Column(name = "adresse")
	private String adrs_prof;
	
	@Column(name = "date_embauche")
	private Date date_embauche;
	
	@Column(name = "tel")
	private String tel_prof;
	
	@Column(name = "date_depart")
	private Date date_depart;
	
	//constructeurs
	public Prof() {}
	
	public Prof(String nom_prof, String prenom_prof, String adrs_prof, Date date_embauche, String tel_prof, Date date_depart)
	{
		this.nom_prof = nom_prof;
		this.prenom_prof = prenom_prof;
		this.adrs_prof = adrs_prof;
		this.date_embauche = date_embauche;
		this.tel_prof = tel_prof;
		this.date_depart = date_depart;
	}
	
	//getters
	public int getId() {
		return id_prof;
	}
	
	public String getNom() {
		return nom_prof;
	}
	
	public String getPrenom() {
		return prenom_prof;
	}	
	
	public String getAdrs() {
		return adrs_prof;
	}
	
	public Date getDateEmb() {
		return date_embauche;
	}
	
	public String getTel() {
		return tel_prof;
	}
	
	public Date getDateDep() {
		return date_depart;
	}
	
	//setters
	public void setId(int id_prof) {
		this.id_prof = id_prof;
	}
	
	public void setNom(String nom_prof) {
		this.nom_prof = nom_prof;
	}
	
	public void setPrenom(String prenom_prof) {
		this.prenom_prof = prenom_prof;
	}	
	
	public void setAdrs(String adrs_prof) {
		this.adrs_prof = adrs_prof;
	}
	
	public void setDateEmb(Date date_embauche) {
		this.date_embauche = date_embauche;
	}
	
	public void setTel(String tel_prof) {
		this.tel_prof = tel_prof;
	}
	
	public void setDateDep(Date date_depart) {
		this.date_depart = date_depart;
	}
}
