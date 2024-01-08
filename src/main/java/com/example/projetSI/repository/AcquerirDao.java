package com.example.projetSI.repository;

import com.example.projetSI.model.Acquerir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcquerirDao extends JpaRepository<Acquerir, Acquerir.AcquerirId> {
    Optional<Acquerir> findAcquerirById(Acquerir.AcquerirId id);
}
