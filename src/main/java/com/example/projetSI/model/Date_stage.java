package com.example.projetSI.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Date stage")
public class Date_stage implements Serializable {

    @EmbeddedId
    private DateStageId id;

    @ManyToOne
    @MapsId("typeStageId")
    @JoinColumn(name = "type stage")
    private Type_Stage type_stage;

    @ManyToOne
    @MapsId("anneeId")
    @JoinColumn(name = "annee")
    private Annee annee;

    @Column(name = "debut")
    private Date debut;

    @Column(name = "fin")
    private Date fin;

    public Date_stage() {
    }

    public Date_stage(Type_Stage type_stage, Annee annee, Date debut, Date fin) {
        this.type_stage = type_stage;
        this.annee = annee;
        this.debut = debut;
        this.fin = fin;
    }

    public Type_Stage getType_stage() {
        return type_stage;
    }

    public void setType_stage(Type_Stage type_stage) {
        this.type_stage = type_stage;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Embeddable
    public class DateStageId implements Serializable {
        @Column(name = "type_stage_id")
        private String typeStageId;
        @Column(name = "annee_id")
        private int anneeId;

        public DateStageId() {
        }

        public DateStageId(String typeStageId, int anneeId) {
            this.typeStageId = typeStageId;
            this.anneeId = anneeId;
        }

        public String getTypeStageId() {
            return typeStageId;
        }

        public void setTypeStageId(String typeStageId) {
            this.typeStageId = typeStageId;
        }

        public int getAnneeId() {
            return anneeId;
        }

        public void setAnneeId(int anneeId) {
            this.anneeId = anneeId;
        }
    }
}
