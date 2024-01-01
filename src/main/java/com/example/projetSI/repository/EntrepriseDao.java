package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Entreprise;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Integer> {
	Optional<Entreprise> findEntrepriseById(int id);

}
