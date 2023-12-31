package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tuteur")
public class Tuteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7188867176954478198L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
	
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "tel")
    private String tel;
    
    //constructeurs

    public Tuteur() {
    }

    public Tuteur(String nom_tuteur, String prenom_tuteur, String tel_tuteur) {
        this.nom = nom_tuteur;
        this.prenom = prenom_tuteur;
        this.tel = tel_tuteur;
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
    
    public String getTel() {
        return tel;
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


    public void setTel(String tel_tuteur) {
        this.tel = tel_tuteur;
    }
	
}
