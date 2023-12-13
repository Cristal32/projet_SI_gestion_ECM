package com.example.projetSI.model;

import jakarta.persistence.*;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "N_competence", unique = true, nullable = false)
    private String N_competence;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "description")
    private String description;

    public Competence() {
    }

    public Competence(String n_competence, String libelle, String description) {
        this.N_competence = n_competence;
        this.libelle = libelle;
        this.description = description;
    }

    public String getN_competence() {
        return N_competence;
    }

    public void setN_competence(String n_competence) {
        N_competence = n_competence;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
