package com.example.projetSI.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etudiant", unique = true, nullable = false)
    private int id_etud;

    @Column(name = "nom")
    private String nom_etud;

    @Column(name = "prenom")
    private String prenom_etud;

    @Column(name = "adresse")
    private String adrs_etud;

    @Column(name = "date_naissance")
    private Date date_naiss;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "tel")
    private String tel_etud;

    @Column(name = "mention")
    private String mention;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "promo")
    private Promo promo_etud;

    //constructeurs
    public Etudiant() {}

    public Etudiant(String nom_etud, String prenom_etud, String adrs_etud, Date date_naiss, String sexe, String tel_etud, String mention, Promo promo_etud)
    {
        this.nom_etud = nom_etud;
        this.prenom_etud = prenom_etud;
        this.adrs_etud = adrs_etud;
        this.date_naiss = date_naiss;
        this.sexe = sexe;
        this.tel_etud = tel_etud;
        this.mention = mention;
        this.promo_etud = promo_etud;
    }

    //getters
    public int getId() {
        return id_etud;
    }

    public String getNom() {
        return nom_etud;
    }

    public String getPrenom() {
        return prenom_etud;
    }

    public String getAdrs() {
        return adrs_etud;
    }

    public Date getDateNaissance() {
        return date_naiss;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTel() {
        return tel_etud;
    }

    public String getMention() {
        return mention;
    }

    public Promo getPromo() {
        return promo_etud;
    }

    //setters
    public void setId(int id) {
        this.id_etud = id;
    }

    public void setNom(String nom) {
        this.nom_etud = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom_etud = prenom;
    }

    public void setAdrs(String adrs) {
        this.adrs_etud = adrs;
    }

    public void setDateNaissance(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTel(String tel) {
        this.tel_etud = tel;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public void setPromo(Promo promo) {
        this.promo_etud = promo;
    }
}
