package com.example.projetSI.repository;

import com.example.projetSI.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessDao extends JpaRepository<Access, Integer> {
    Optional<Access> findAccessById(int id);
    Optional<Access> findAccessByLibelle(String libelle);
    Optional<Access> findByCode(String code);
    public void deleteAccessById(int id);
}
