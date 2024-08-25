package com.example.projetSI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSI.modal.Acquerir;

@Repository
public interface AcquerirDao extends JpaRepository<Acquerir, Acquerir.AcquerirId> {
	Optional<Acquerir> findAcquerirById(Acquerir.AcquerirId id);
}
