package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TypeStage")
public class Type_stage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457588864077896139L;
	
	@Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;
	
	@Column(name = "Nbr semaines")
    private String nbr_semaines;
	
	//constructeurs
	
	public Type_stage() {
    }

    public Type_stage(String code, String nbr_semaines) {
    	this.code = code;
        this.nbr_semaines = nbr_semaines;
    }
    
    //getters
    
    public String getCode() {
    	return this.code;
    }
    
    public String getNbrSemaines() {
    	return this.nbr_semaines;
    }
    
    //setters
    
    public void setCode(String code) {
    	this.code = code;
    }
    
    public void setNbrSemaines(String nbr_semaines) {
    	this.nbr_semaines = nbr_semaines;
    }
}
