package com.example.projetSI.model;

import java.io.Serializable;

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
@Table(name = "promo")
public class Promo implements Serializable {

    @Id
    @Column(name = "annee", unique = true, nullable = false)
    private int annee;

    @Column(name = "nbr_inscrits")
    private int nbr_inscrits;

    @Column(name = "nbr_recus")
    private int nbr_recus;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "dirigeant")
    private Prof prof_dirigeant;

    //constructeurs
    public Promo() {}

    public Promo(int annee, int nbr_inscrits, int nbr_recus, Prof prof_dirigeant)
    {
        this.annee = annee;
        this.nbr_inscrits = nbr_inscrits;
        this.nbr_recus = nbr_recus;
        this.prof_dirigeant = prof_dirigeant;
    }

    //getters
    public int getAnnee() {
        return annee;
    }

    public int getNbrInscrits() {
        return nbr_inscrits;
    }

    public int getNbrRecus() {
        return nbr_recus;
    }

    public Prof getDirigeant() {
        return prof_dirigeant;
    }

    //setters
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setNbrInscrits(int nbr_inscrits) {
        this.nbr_inscrits = nbr_inscrits;
    }

    public void setNbrRecus(int nbr_recus) {
        this.nbr_recus = nbr_recus;
    }

    public void setDirigeant(Prof prof_dirigeant) {
        this.prof_dirigeant = prof_dirigeant;
    }
}