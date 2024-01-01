package com.example.projetSI.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Tuteur")
public class Tuteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuteur", unique = true, nullable = false)
    private int id_tuteur;
    @Column(name = "nom tuteur")
    private String nom_tuteur;
    @Column(name = "prenom tuteur")
    private String prenom_tuteur;
    @Column(name = "tel tuteur")
    private String tel_tuteur;

    public Tuteur() {
    }

    public Tuteur(String nom_tuteur, String prenom_tuteur, String tel_tuteur) {
        this.nom_tuteur = nom_tuteur;
        this.prenom_tuteur = prenom_tuteur;
        this.tel_tuteur = tel_tuteur;
    }

    public int getId_tuteur() {
        return id_tuteur;
    }

    public void setId_tuteur(int id_tuteur) {
        this.id_tuteur = id_tuteur;
    }

    public String getNom_tuteur() {
        return nom_tuteur;
    }

    public void setNom_tuteur(String nom_tuteur) {
        this.nom_tuteur = nom_tuteur;
    }

    public String getPrenom_tuteur() {
        return prenom_tuteur;
    }

    public void setPrenom_tuteur(String prenom_tuteur) {
        this.prenom_tuteur = prenom_tuteur;
    }

    public String getTel_tuteur() {
        return tel_tuteur;
    }

    public void setTel_tuteur(String tel_tuteur) {
        this.tel_tuteur = tel_tuteur;
    }
}
