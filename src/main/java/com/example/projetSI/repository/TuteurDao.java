package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Tuteur;

@Repository
public interface TuteurDao extends JpaRepository<Tuteur, Integer> {
	
	Optional<Tuteur> findTuteurById(int id);

}
