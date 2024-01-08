package com.example.projetSI.repository;

import com.example.projetSI.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatDao extends JpaRepository<Candidat, String> {
    Optional<Candidat> findCandidatByEmail(String email);
}
