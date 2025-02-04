package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Competence;

public interface CompetenceService {
	public List<Competence> getAllCompetences();
	public Competence findCompetenceByCode(String code);
	public Competence addCompetence(Competence competence);
	public Competence updateCompetence(Competence competence);
	public void deleteCompetence(String code);
}
