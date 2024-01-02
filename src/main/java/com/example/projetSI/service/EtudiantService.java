package com.example.projetSI.service;

import com.example.projetSI.model.Etudiant;

import java.util.List;

public interface EtudiantService {
    public List<Etudiant> getAllEtudiants();
    public Etudiant findEtudiantById(int id);
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiant(int id);
}
