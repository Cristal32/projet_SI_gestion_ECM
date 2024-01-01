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
@Table(name = "Candidat")
public class Candidat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382650080538671428L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat", unique = true, nullable = false)
    private int id;
	
	@Column(name = "dossier")
    private String dossier;
	
	@Column(name = "statut")
    private String statut;
	
	@Column(name = "dossier_complete")
    private String dossier_complete;
	
	@ManyToOne
    @JoinColumn(name = "promo", nullable = false)
    private Promo promo;

}
