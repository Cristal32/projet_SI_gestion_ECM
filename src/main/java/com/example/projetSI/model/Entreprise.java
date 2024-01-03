package com.example.projetSI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Entreprise")
public class Entreprise implements Serializable {

    @Id
    @Column(name = "siret", unique = true, nullable = false)
    private String siret;

    @Column(name = "raison social")
    private String raison_social;

    @Column(name = "forme juridique")
    private String forme_juridique;

    @Column(name = "adresse entreprise")
    private String adrs_entreprise;

    @Column(name = "tel standard")
    private String tel_standard;

    @Column(name = "contact")
    private String contact;

    @Column(name = "tel contact")
    private String tel_contact;

    public Entreprise() {
    }

    public Entreprise(String siret, String raison_social, String forme_juridique, String adrs_entreprise, String tel_standard, String contact, String tel_contact) {
        this.siret = siret;
        this.raison_social = raison_social;
        this.forme_juridique = forme_juridique;
        this.adrs_entreprise = adrs_entreprise;
        this.tel_standard = tel_standard;
        this.contact = contact;
        this.tel_contact = tel_contact;
    }

    public String getSiret() {
        return siret;
    }

    public String getRaison_social() {
        return raison_social;
    }

    public String getForme_juridique() {
        return forme_juridique;
    }

    public String getAdrs_entreprise() {
        return adrs_entreprise;
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

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public void setRaison_social(String raison_social) {
        this.raison_social = raison_social;
    }

    public void setForme_juridique(String forme_juridique) {
        this.forme_juridique = forme_juridique;
    }

    public void setAdrs_entreprise(String adrs_entreprise) {
        this.adrs_entreprise = adrs_entreprise;
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
