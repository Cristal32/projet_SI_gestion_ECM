package com.example.projetSI.model;

import jakarta.persistence.*;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat")
    private int id_candidat;

    @Column(name = "email_candidat")
    private String email_candidat;

    @Column(name = "statut")
    private String statut;

    @Column(name = "dossier_complete")
    private String dossier_complete;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_candidat")
    private Promo promo_candidat;

    public Candidat() {
    }

    public Candidat(String email_candidat, String statut, String dossier_complete, Promo promo_candidat) {
        this.email_candidat = email_candidat;
        this.statut = statut;
        this.dossier_complete = dossier_complete;
        this.promo_candidat = promo_candidat;
    }

    public int getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }

    public String getEmail_candidat() {
        return email_candidat;
    }

    public void setEmail_candidat(String email_candidat) {
        this.email_candidat = email_candidat;
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

    public Promo getPromo_candidat() {
        return promo_candidat;
    }

    public void setPromo_candidat(Promo promo_candidat) {
        this.promo_candidat = promo_candidat;
    }
}
