package com.example.projetSI.repository;

import com.example.projetSI.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, String> {
    Optional<Entreprise> findEntrepriseBySiret(String siret);
}
