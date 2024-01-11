package com.example.projetSI.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "role")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "libelle", length = 100, unique = true)
    private String libelle;

    //@ManyToMany(cascade = CascadeType.ALL)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_access", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "role_id") }, inverseJoinColumns = {
            @JoinColumn(name = "access_id", referencedColumnName = "access_id") })
    private Set<Access> accesses = new HashSet<>();

    //constructeurs
    public Role() {}

    public Role(String libelle) {
        this.libelle = libelle;
    }

    //NEW - removed id attr
    public Role(String libelle, Set<Access> accesses) {
        this.libelle = libelle;
        this.accesses = accesses;
    }

    //getters
    public Integer getId() {
        return id;
    }
    public String getLibelle() {
        return libelle;
    }
    public Set<Access> getAccesses(){
        return accesses;
    }

    //setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setAccesses(Set<Access> accesses) {
        this.accesses = accesses;
    }

    //methods
    @Override
    public String toString() {
        return "Role{" +
                "id = " + id +
                ", libelle = " + libelle +
                "}";
    }
}