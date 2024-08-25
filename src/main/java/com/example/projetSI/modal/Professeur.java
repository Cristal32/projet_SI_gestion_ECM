package com.example.projetSI.modal;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Professeur")
public class Professeur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8344420100946266161L;

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof", unique = true, nullable = false)
    private String id;
	
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
	
	public Professeur(String id, String nom, String prenom, String adrs, Date date_emb, String tel, Date date_dep) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adrs = adrs;
		this.date_emb = date_emb;
		this.tel = tel;
		this.date_dep = date_dep;
	}
	
	//getters
	
	public String getId() {
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

    public void setId(String id_prof) {
        this.id = id_prof;
    }

    public void setNom(String nom_prof) {
        this.nom = nom_prof;
    }

    public void setPrenom(String prenom_prof) {
        this.prenom = prenom_prof;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
    
    public void setDateEmbauche(Date date_emb) {
        this.date_emb = date_emb;
    }

    public void setTel(String tel_prof) {
        this.tel = tel_prof;
    }
    
    public void setDateDepart(Date date_dep) {
        this.date_dep = date_dep;
    }
}
