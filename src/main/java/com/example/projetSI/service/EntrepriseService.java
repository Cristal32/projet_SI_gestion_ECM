package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Entreprise;


public interface EntrepriseService {
	
	public List<Entreprise> getAllEntreprises();
	public Entreprise findEntrepriseById(int id);
	public Entreprise addEntreprise(Entreprise entreprise);
	public Entreprise updateEntreprise(Entreprise entreprise);
	public void deleteEntreprise(int id);

}
