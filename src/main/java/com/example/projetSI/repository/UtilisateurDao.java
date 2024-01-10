package com.example.projetSI.repository;

import com.example.projetSI.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findUtilisateurById(int id);
    Optional<Utilisateur> findByUsername(String username);
}
