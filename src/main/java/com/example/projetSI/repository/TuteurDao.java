package com.example.projetSI.repository;

import com.example.projetSI.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TuteurDao extends JpaRepository<Tuteur, String> {
    Optional<Tuteur> findTuteurById(String id);
}
