package com.example.projetSI.model;

import jakarta.persistence.*;

@Entity
public class Annee {
    @Id
    @Column(name = "annee", unique = true, nullable = false)
    private int annee;

    public Annee(int annee) {
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
