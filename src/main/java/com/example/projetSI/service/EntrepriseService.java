package com.example.projetSI.service;

import com.example.projetSI.model.Entreprise;

import java.util.List;

public interface EntrepriseService {
    public List<Entreprise> getAllEntreprises();
    public Entreprise findEntrepriseBySiret(String siret);
    public Entreprise addEntreprise(Entreprise entreprise);
    public Entreprise updateEntreprise(Entreprise entreprise);
    public void deleteEntreprise(String siret);
}
