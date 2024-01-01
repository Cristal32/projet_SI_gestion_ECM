package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TypeStage")
public class TypeStage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457588864077896139L;
	
	@Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
	
	@Column(name = "Nbr semaines")
    private String nbr_semaines;
	
	//constructeurs
	
	public TypeStage() {
    }

    public TypeStage(int id, String nbr_semaines) {
    	this.id = id;
        this.nbr_semaines = nbr_semaines;
    }
    
    //getters
    
    public int getId() {
    	return this.id;
    }
    
    public String getNbrSemaines() {
    	return this.nbr_semaines;
    }
    
    //setters
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setNbrSemaines(String nbr_semaines) {
    	this.nbr_semaines = nbr_semaines;
    }
}
