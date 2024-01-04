package com.example.projetSI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stage", unique = true, nullable = false)
    private int id_stage;

    @Column(name = "annee stage")
    private int annee_stage;

    @Column(name = "compte rendu")
    private String compte_rendu;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "siret")
    private Entreprise entreprise;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prof")
    private Prof prof;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "n_type")
    private Type_Stage type;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tuteur")
    private Tuteur tuteur;

    @Column(name = "statut_stage")
    private String statut_stage;

    public Stage() {
    }

    public Stage(int annee_stage, String compte_rendu, Etudiant etudiant, Entreprise entreprise, Prof prof, Type_Stage type, Tuteur tuteur, String statut_stage) {
        this.annee_stage = annee_stage;
        this.compte_rendu = compte_rendu;
        this.etudiant = etudiant;
        this.entreprise = entreprise;
        this.prof = prof;
        this.type = type;
        this.tuteur = tuteur;
        this.statut_stage = statut_stage;
    }

    public int getId() {
        return id_stage;
    }

    public void setId(int id_stage) {
        this.id_stage = id_stage;
    }

    public int getAnnee() {
        return annee_stage;
    }

    public void setAnnee(int annee_stage) {
        this.annee_stage = annee_stage;
    }

    public String getCompte_rendu() {
        return compte_rendu;
    }

    public void setCompte_rendu(String compte_rendu) {
        this.compte_rendu = compte_rendu;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Type_Stage getType() {
        return type;
    }

    public void setType(Type_Stage type) {
        this.type = type;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public String getStatut() {
        return statut_stage;
    }

    public void setStatut(String statut_stage) {
        this.statut_stage = statut_stage;
    }
}
