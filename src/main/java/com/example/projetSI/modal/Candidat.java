package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Candidat")
public class Candidat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382650080538671428L;
	
	@Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;
	
	@Column(name = "nom")
    private String nom;
	
	@Column(name = "prenom")
    private String prenom;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dossier")
    private FileData dossier;
	
	@Column(name = "statut")
    private String statut;
	
	@Column(name = "dossier_complete")
    private String dossier_complete;
	
	@ManyToOne
    @JoinColumn(name = "promo", nullable = false)
    private Promo promo;
	
	//constructeurs
	
	public Candidat() {
    }

    public Candidat(FileData dossier, String email_candidat, String statut, String dossier_complete, Promo promo, String nom, String prenom) {
        this.dossier = dossier;
        this.email= email_candidat;
        this.statut = statut;
        this.dossier_complete = dossier_complete;
        this.promo = promo;
    }
    
    //getters

    public String getEmail() {
        return email;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public FileData getDossier() {
        return dossier;
    }
    
    public String getDossierComplete() {
        return dossier_complete;
    }
    
    
    public Promo getPromo() {
        return promo;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    //setters

    public void setEmail(String email_candidat) {
        this.email = email_candidat;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDossierComplete(String dossier_complete) {
        this.dossier_complete = dossier_complete;
    }

    public void setDossier(FileData dossier) {
        this.dossier = dossier;
    }


    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
