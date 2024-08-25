package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.DateStage;

@Repository
public interface DateStageDao extends JpaRepository<DateStage, DateStage.DateStageId> {
	Optional<DateStage> findDateStageById(DateStage.DateStageId id);
}
