package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Etudiant;


@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
	Optional<Etudiant> findEtudiantById(int id);

}
