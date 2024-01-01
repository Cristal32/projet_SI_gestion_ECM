package com.example.projetSI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "TypeStage")
public class Type_Stage implements Serializable {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "Nbr semaines")
    private String nbr_semaines;

    public Type_Stage() {
    }

    public Type_Stage(String code, String nbr_semaines) {
        this.code = code;
        this.nbr_semaines = nbr_semaines;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNbr_semaines() {
        return nbr_semaines;
    }

    public void setNbr_semaines(String nbr_semaines) {
        this.nbr_semaines = nbr_semaines;
    }
}
