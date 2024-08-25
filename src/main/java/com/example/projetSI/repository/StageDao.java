package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Stage;

@Repository
public interface StageDao extends JpaRepository<Stage, Integer> {
	Optional<Stage> findStageById(int id);
}
