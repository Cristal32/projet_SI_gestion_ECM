package com.example.projetSI.modal;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Professeur")
public class Professeur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8344420100946266161L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof", unique = true, nullable = false)
    private int id;
	
	@Column(name = "nom")
    private String nom;
	
	@Column(name = "prenom")
    private String prenom;
	
	@Column(name = "adresse")
    private String adrs;
	
	@Column(name = "date_embauche")
    private Date date_emb;
	
	@Column(name = "tel")
    private String tel;
	
	@Column(name = "date_depart")
    private Date date_dep;
	
	//constructeurs
	
	public Professeur() {}
	
	public Professeur(String nom, String prenom, String adrs, Date date_emb, String tel, Date date_dep) {
		this.nom = nom;
		this.prenom = prenom;
		this.adrs = adrs;
		this.date_emb = date_emb;
		this.tel = tel;
		this.date_dep = date_dep;
	}
	
	//getters
	
	public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getAdrs() {
        return adrs;
    }
    
    public Date getDateEmbauche() {
        return date_emb;
    }
    
    public String getTel() {
        return tel;
    }
    
    public Date getDateDepart() {
        return date_dep;
    }
    
    //setters

    public void setId(int id_tuteur) {
        this.id = id_tuteur;
    }

    public void setNom(String nom_tuteur) {
        this.nom = nom_tuteur;
    }

    public void setPrenom(String prenom_tuteur) {
        this.prenom = prenom_tuteur;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
    
    public void setDateEmbauche(Date date_emb) {
        this.date_emb = date_emb;
    }

    public void setTel(String tel_tuteur) {
        this.tel = tel_tuteur;
    }
    
    public void setDateDepart(Date date_dep) {
        this.date_dep = date_dep;
    }
}
