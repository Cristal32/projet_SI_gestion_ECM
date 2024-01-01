package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.TypeStage;

@Repository
public interface TypeStageDao extends JpaRepository<TypeStage, Integer> {
	Optional<TypeStage> findTypeStageById(int id);

}
