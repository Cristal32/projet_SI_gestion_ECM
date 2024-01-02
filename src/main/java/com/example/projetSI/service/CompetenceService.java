package com.example.projetSI.service;

import com.example.projetSI.model.Competence;

import java.util.List;

public interface CompetenceService {
    public List<Competence> getAllCompetences();
    public Competence findCompetenceByCode(String code);
    public Competence addCompetence(Competence competence);
    public Competence updateCompetence(Competence competence);
    public void deleteCompetence(String code);
}
