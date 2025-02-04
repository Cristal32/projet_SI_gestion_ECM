package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Etudiant;

public interface EtudiantService {

	public List<Etudiant> getAllEtudiants();
	public Etudiant findEtudiantById(int id);
	public Etudiant addEtudiant(Etudiant etudiant);
	public Etudiant updateEtudiant(Etudiant etudiant);
	public void deleteEtudiant(int id);
}
