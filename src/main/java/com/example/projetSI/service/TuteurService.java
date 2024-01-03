package com.example.projetSI.service;

import com.example.projetSI.model.Tuteur;

import java.util.List;

public interface TuteurService {
    public List<Tuteur> getAllTuteurs();
    public Tuteur findTuteurById(String id);
    public Tuteur addTuteur(Tuteur tuteur);
    public Tuteur updateTuteur(Tuteur tuteur);
    public void deleteTuteur(String id);
}
