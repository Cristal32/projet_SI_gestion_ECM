package com.example.projetSI.model;

import jakarta.persistence.*;

@Entity
public class Type_Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_type", unique = true, nullable = false)
    private int N_type;
    @Column(name = "duree")
    private String duree;

    public Type_Stage() {
    }

    public Type_Stage(String duree) {
        this.duree = duree;
    }

    public int getN_type() {
        return N_type;
    }

    public void setN_type(int n_type) {
        N_type = n_type;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
