package com.example.projetSI.repository;

import com.example.projetSI.model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfDao extends JpaRepository<Prof, Integer> {
    Optional<Prof> findProfById(int id);
}
