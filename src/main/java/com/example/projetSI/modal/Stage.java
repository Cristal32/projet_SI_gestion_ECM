package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stage")
public class Stage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6011319234823939099L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stage", unique = true, nullable = false)
    private int id;
	
	@Column(name = "annee")
    private int annee;
	
	@Column(name = "compte_rendu")
    private String compte_rendu;
	
	@ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;
	
	@ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;
	
	@ManyToOne
    @JoinColumn(name = "prof_id", nullable = true)
    private Professeur prof;
	
	@ManyToOne
    @JoinColumn(name = "type_stage", nullable = false)
    private TypeStage type_stage;
	
	@ManyToOne
    @JoinColumn(name = "tuteur_id", nullable = true)
    private Tuteur tuteur;
	
	//constructeurs
	
	public Stage() {}
	
	public Stage(int annee, String compte_rendu, Etudiant etudiant, Entreprise entreprise, Professeur prof, TypeStage type_stage, Tuteur tuteur) {
		this.annee = annee;
		this.compte_rendu = compte_rendu;
		this.etudiant = etudiant;
		this.entreprise = entreprise;
		this.prof = prof;
		this.type_stage = type_stage;
		this.tuteur = tuteur;
	}
	
	//getters
	
	public int getAnnee() {
		return this.annee;
	}
	
	public String getCompteRendu() {
		return this.compte_rendu;
	}
	
	public Etudiant getEtudiant() {
		return this.etudiant;
	}
	
	public Entreprise getEntreprise() {
		return this.entreprise;
	}
	
	public Professeur getProf() {
		return this.prof;
	}
	
	public TypeStage getTypeStage() {
		return this.type_stage;
	}
	
	public Tuteur getTuteur() {
		return this.tuteur;
	}
	
	//setters
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public void setCompteRendu(String compte_rendu) {
		this.compte_rendu = compte_rendu;
	}
	
	public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
	}
	
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	
	public void setTypeStage(TypeStage type_stage) {
		this.type_stage = type_stage;
	}
	
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}

}
