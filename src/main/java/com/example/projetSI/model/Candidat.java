package com.example.projetSI.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Candidat {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private Date date_naiss;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "statut")
    private String statut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dossier")
    private FileData dossier;

    @Column(name = "dossier_complete")
    private String dossier_complete;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_candidat")
    private Promo promo_candidat;

    public Candidat() {
    }

    public Candidat(FileData dossier, String email_candidat, String statut, String dossier_complete, Promo promo_candidat) {
        this.dossier = dossier;
        this.email= email_candidat;
        this.statut = statut;
        this.dossier_complete = dossier_complete;
        this.promo_candidat = promo_candidat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_candidat) {
        this.email = email_candidat;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDossier_complete() {
        return dossier_complete;
    }

    public void setDossier_complete(String dossier_complete) {
        this.dossier_complete = dossier_complete;
    }

    public FileData getDossier() {
        return dossier;
    }

    public void setDossier(FileData dossier) {
        this.dossier = dossier;
    }

    public Promo getPromo() {
        return promo_candidat;
    }

    public void setPromo(Promo promo_candidat) {
        this.promo_candidat = promo_candidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return date_naiss;
    }

    public void setDateNaissance(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
