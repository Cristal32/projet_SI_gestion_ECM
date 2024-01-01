package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Professeur;

@Repository
public interface ProfDao extends JpaRepository<Professeur, Integer> {
	Optional<Professeur> findProfById(int id);
}
