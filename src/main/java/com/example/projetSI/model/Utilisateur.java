package com.example.projetSI.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id", unique = true, nullable = false)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    private Etudiant etudiant;

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidat")
    private Candidat candidat;

    //constructors
    public Utilisateur() {}

    public Utilisateur(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public Role getRole(){
        return role;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    //methods
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id = " + id +
                ", username = " + username +
                ", pwd = " + password +
                "}";
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}