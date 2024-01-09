package com.example.projetSI.modal;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -1210773408862302224L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utilisateur_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
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
	public int getUserId() {
		return id;
	}
	public String getUserPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	public Role getUserRole(){
		return role;
	}
	
	//setters
	public void setUserId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserPassword(String password) {
		this.password = password;
	}
	public void setUserRole(Role role) {
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
	
}