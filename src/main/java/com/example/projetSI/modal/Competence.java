package com.example.projetSI.modal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Competence")
public class Competence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4910915134934727654L;
	
	@Id 
    @Column(name = "code", unique = true, nullable = false)  //le code n'est pas genere autimatiquement
    private String code;
	
	@Column(name = "libelle")
    private String libelle;
	
	@Column(name = "description")
    private String desc;
	
	//constructeurs
	
	public Competence() {
	    }

    public Competence(String code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.desc = description;
    }
    
    //getters

    public String getCode() {
        return code;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public String getDesc() {
        return desc;
    }
    
    //setters

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDesc(String description) {
        this.desc = description;
    }
}
