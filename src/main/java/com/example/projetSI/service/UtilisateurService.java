package com.example.projetSI.service;

import com.example.projetSI.model.Access;
import com.example.projetSI.model.Utilisateur;

import java.util.List;
import java.util.Set;

public interface UtilisateurService {
    public List<Utilisateur> getAllUtilisateur();
    public Utilisateur findUtilisateurById(int id);
    public Set<Access> getUtilisateurAccesses(Utilisateur user);
    public Utilisateur addUtilisateur(Utilisateur user);
    public Utilisateur updateUtilisateur(Utilisateur user);
    public void deleteUtilisateur(int id);
    public Utilisateur authentifierUtilisateur(String username, String password);
}
