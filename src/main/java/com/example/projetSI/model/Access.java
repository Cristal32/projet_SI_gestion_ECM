package com.example.projetSI.model;


import java.io.Serializable;

//import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access")
public class Access implements Serializable/*, GrantedAuthority*/{

    @Id
    @GeneratedValue
    @Column(name = "access_id", unique = true, nullable = false)
    private int id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "code")
    private String code;

    //constructeurs
    public Access() {}

    public Access(int id, String libelle, String code) {
        this.id = id;
        this.libelle = libelle;
        this.code = code;
    }

    //getters
    public int getAccessId() {
        return id;
    }
    public String getAccessLibelle() {
        return libelle;
    }
    public String getAuthority() {
        return code;
    }

    //setters
    public void setAccessId(int id) {
        this.id = id;
    }
    public void setAccessLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setAuthority(String code) {
        this.code = code;
    }

    //methods
    @Override
    public String toString() {
        return "Access{" +
                "id = " + id +
                ", libelle = " + libelle +
                ", code = " + code +
                "}";
    }
}