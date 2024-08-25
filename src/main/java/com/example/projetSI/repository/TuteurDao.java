package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Tuteur;

@Repository
public interface TuteurDao extends JpaRepository<Tuteur, String> {
	Optional<Tuteur> findTuteurById(String id);
	void deleteTuteurById(String id);
}
