package com.example.projetSI.modal;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Acquerir")
public class Acquerir implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -997209147918813042L;
	
	@EmbeddedId
    private AcquerirId id;

	@ManyToOne
	@MapsId("typeStageId")
    @JoinColumn(name = "type stage")
    private TypeStage type_stage;
	
	@ManyToOne
	@MapsId("competenceId")
    @JoinColumn(name = "code competence")
    private Competence competence;
	
	@Column(name = "niveau exige")
    private int niveau;
	
	//constructeurs
	
	public Acquerir() {
		
	}
	
	public Acquerir(TypeStage type_stage, Competence competence, int niv) {
		this.type_stage = type_stage;
		this.competence = competence;
		this.niveau = niv;
	}
	
	//getters
	
	public AcquerirId getId() {
		return this.id;
	}
	
	public TypeStage getTypeStage() {
		return this.type_stage;
	}
	
	public Competence getCompetence() {
		return this.competence;
	}
	
	public int getNiveau() {
		return this.niveau;
	}
	
	//setters
	
	public void setId(AcquerirId id) {
		this.id = id;
	}
	
	public void setTypeStage(TypeStage type_stage) {
		this.type_stage = type_stage;
	}
	
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	public void setNiveau(int niv) {
		this.niveau = niv;
	}
	
	@Embeddable
	public static class AcquerirId implements Serializable {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1920211291036854792L;

		@Column(name = "type_stage_id")
	    private int typeStageId;

	    @Column(name = "competence_id")
	    private String competenceId;

	    //constructeurs
	    
	    public AcquerirId() {}
	    
	    public AcquerirId(int typeStageId, String competenceId) {
	    	this.typeStageId = typeStageId;
	    	this.competenceId = competenceId;
	    }
	    
	    //getters
	    
	    public int getTypeStageId() {
	    	return this.typeStageId;
	    }
	    
	    public String getCompetenceId() {
	    	return this.competenceId;
	    }
	    
	    //setters
	    
	    public void setTypeStageId(int typeStageId) {
	    	this.typeStageId = typeStageId;
	    }
	    
	    public void setCompetenceId(String competenceId) {
	    	this.competenceId = competenceId;
	    }
	}
}

