package com.example.projetSI.modal;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Date stage")
public class DateStage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4704784094852834905L;
	
	@EmbeddedId
    private DateStageId id;

	@ManyToOne
	@MapsId("typeStageId")
    @JoinColumn(name = "type stage")
    private TypeStage type_stage;
	
	@ManyToOne
	@MapsId("anneeId")
    @JoinColumn(name = "annee")
    private Annee annee;
	
	@Column(name = "debut")
    private Date debut;
	
	@Column(name = "fin")
    private Date fin;
	
	//constructeurs
	
	public DateStage() {
		
	}
	
	public DateStage(TypeStage type_stage, Annee annee, Date debut, Date fin) {
		this.type_stage = type_stage;
		this.annee = annee;
		this.debut = debut;
		this.fin = fin;
	}
	
	//getters
	
	public DateStageId getId() {
		return this.id;
	}
	
	public TypeStage getTypeStage() {
		return this.type_stage;
	}
	
	public Annee getAnnee() {
		return this.annee;
	}
	
	public Date getDateDeb() {
		return this.debut;
	}
	
	public Date getDateFin() {
		return this.fin;
	}
	
	//setters
	
	public void setId(DateStageId id) {
		this.id = id;
	}
	
	public void setTypeStage(TypeStage type_stage) {
		this.type_stage = type_stage;
	}
	
	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	
	public void setDateDeb(Date debut) {
		this.debut = debut;
	}
	
	public void setDateFin(Date fin) {
		this.fin = fin;
	}
	
	@Embeddable
	public static class DateStageId implements Serializable {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1920211291036854792L;

		@Column(name = "type_stage_id")
	    private int typeStageId;

	    @Column(name = "annee_id")
	    private int anneeId;

	    //constructeurs
	    
	    public DateStageId() {}
	    
	    public DateStageId(int typeStageId, int anneeId) {
	    	this.typeStageId = typeStageId;
	    	this.anneeId = anneeId;
	    }
	    
	    //getters
	    
	    public int getTypeStageId() {
	    	return this.typeStageId;
	    }
	    
	    public int getAnneeId() {
	    	return this.anneeId;
	    }
	    
	    //setters
	    
	    public void setTypeStageId(int typeStageId) {
	    	this.typeStageId = typeStageId;
	    }
	    
	    public void setAnneeId(int anneeId) {
	    	this.anneeId = anneeId;
	    }
	}

}
