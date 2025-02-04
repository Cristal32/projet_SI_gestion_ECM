package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Tuteur;

public interface TuteurService {
	
	public List<Tuteur> getAllTuteurs();
	public Tuteur findTuteurById(String id);
	public Tuteur addTuteur(Tuteur tuteur);
	public Tuteur updateTuteur(Tuteur tuteur);
	public void deleteTuteur(String id);

}
