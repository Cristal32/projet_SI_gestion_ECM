package com.example.projetSI.repository;

import com.example.projetSI.model.Type_Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeStageDao extends JpaRepository<Type_Stage, String> {
    Optional<Type_Stage> findTypeStageByCode(String code);
}
