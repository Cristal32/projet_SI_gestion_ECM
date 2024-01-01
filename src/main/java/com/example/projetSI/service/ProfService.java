package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Professeur;

public interface ProfService {
	
	public List<Professeur> getAllProfs();
	public Professeur findProfById(int id);
	public Professeur addProf(Professeur prof);
	public Professeur updateProf(Professeur prof);
	public void deleteProf(int id);

}
