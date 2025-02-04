package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Competence;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, String> {
	Optional<Competence> findCompetenceByCode(String code);
	void deleteCompetenceByCode(String code);
}
