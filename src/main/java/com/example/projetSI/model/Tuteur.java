package com.example.projetSI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Tuteur")
public class Tuteur implements Serializable {

    @Id
    @Column(name = "id_tuteur", unique = true, nullable = false)
    private String id_tuteur;
    @Column(name = "nom tuteur")
    private String nom_tuteur;
    @Column(name = "prenom tuteur")
    private String prenom_tuteur;
    @Column(name = "tel tuteur")
    private String tel_tuteur;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "siret")
    private Entreprise entreprise;

    public Tuteur() {
    }

    public Tuteur(String id_tuteur, String nom_tuteur, String prenom_tuteur, String tel_tuteur, Entreprise entreprise) {
        this.entreprise = entreprise;
        this.id_tuteur = id_tuteur;
        this.nom_tuteur = nom_tuteur;
        this.prenom_tuteur = prenom_tuteur;
        this.tel_tuteur = tel_tuteur;
    }

    public String getId() {
        return id_tuteur;
    }

    public void setId(String id_tuteur) {
        this.id_tuteur = id_tuteur;
    }

    public String getNom() {
        return nom_tuteur;
    }

    public void setNom(String nom_tuteur) {
        this.nom_tuteur = nom_tuteur;
    }

    public String getPrenom() {
        return prenom_tuteur;
    }

    public void setPrenom(String prenom_tuteur) {
        this.prenom_tuteur = prenom_tuteur;
    }

    public String getTel() {
        return tel_tuteur;
    }

    public void setTel(String tel_tuteur) {
        this.tel_tuteur = tel_tuteur;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
