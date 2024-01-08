package com.example.projetSI.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Acquerir")
public class Acquerir {
    @EmbeddedId
    private AcquerirId id;

    @ManyToOne
    @MapsId("typeStageId")
    @JoinColumn(name = "type_stage")
    private Type_Stage type_stage;

    @ManyToOne
    @MapsId("competenceId")
    @JoinColumn(name = "competence")
    private Competence competence;

    @Column(name = "niveau exige")
    private int niveau;

    public Acquerir() {
    }

    public Acquerir(Type_Stage type_stage, Competence competence, int niveau) {
        this.type_stage = type_stage;
        this.competence = competence;
        this.niveau = niveau;
    }

    public Type_Stage getType_stage() {
        return type_stage;
    }

    public void setType_stage(Type_Stage type_stage) {
        this.type_stage = type_stage;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Embeddable
    public static class AcquerirId implements Serializable {
        @Column(name = "type_stage_id")
        private String typeStageId;

        @Column(name = "competence_id")
        private String competenceId;

        public AcquerirId() {
        }

        public AcquerirId(String typeStageId, String competenceId) {
            this.typeStageId = typeStageId;
            this.competenceId = competenceId;
        }

        public String getTypeStageId() {
            return typeStageId;
        }

        public void setTypeStageId(String typeStageId) {
            this.typeStageId = typeStageId;
        }

        public String getCompetenceId() {
            return competenceId;
        }

        public void setCompetenceId(String competenceId) {
            this.competenceId = competenceId;
        }
    }
}
