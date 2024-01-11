package com.example.projetSI.repository;

import com.example.projetSI.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StageDao extends JpaRepository<Stage, Integer> {
    Optional<Stage> findStageById(int id);

    List<Stage> findByEtudiantId(int etudiantId);
}
