package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entreprise")
public class Entreprise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8741109641815185358L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entreprise", unique = true, nullable = false)
    private int id;

    @Column(name = "raison sociale")
    private String raison_soc;

    @Column(name = "forme juridique")
    private String forme_jur;

    @Column(name = "adresse")
    private String adrs;

    @Column(name = "tel standard")
    private String tel_standard;

    @Column(name = "contact")
    private String contact;

    @Column(name = "tel contact")
    private String tel_contact;

    public Entreprise() {
    }

    public Entreprise(String raison_social, String forme_juridique, String adrs_entreprise, String tel_standard, String contact, String tel_contact) {
        this.raison_soc = raison_social;
        this.forme_jur = forme_juridique;
        this.adrs = adrs_entreprise;
        this.tel_standard = tel_standard;
        this.contact = contact;
        this.tel_contact = tel_contact;
    }

    public int getId() {
        return id;
    }

    public String getRaisonSoc() {
        return raison_soc;
    }

    public String getFormeJur() {
        return forme_jur;
    }

    public String getAdrs() {
        return adrs;
    }

    public String getTel_standard() {
        return tel_standard;
    }

    public String getContact() {
        return contact;
    }

    public String getTel_contact() {
        return tel_contact;
    }

    //setters
    
    public void setId(int n_entreprise) {
        id = n_entreprise;
    }

    public void setRaisonSoc(String raison_social) {
        this.raison_soc = raison_social;
    }

    public void setFormeJur(String forme_juridique) {
        this.forme_jur = forme_juridique;
    }

    public void setAdrs(String adrs_entreprise) {
        this.adrs = adrs_entreprise;
    }

    public void setTel_standard(String tel_standard) {
        this.tel_standard = tel_standard;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTel_contact(String tel_contact) {
        this.tel_contact = tel_contact;
    }
}
