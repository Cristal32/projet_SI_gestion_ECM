package com.example.projetSI.repository;

import com.example.projetSI.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
    Optional<Etudiant> findEtudiantById(int id);
}
