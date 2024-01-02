package com.example.projetSI.repository;

import com.example.projetSI.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, String> {
    Optional<Competence> findCompetenceByCode(String Code);
}
