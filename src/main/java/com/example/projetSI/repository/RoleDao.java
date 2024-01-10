package com.example.projetSI.repository;

import com.example.projetSI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    Optional<Role> findRoleById(int id);
    void deleteRoleById(int id);
    Optional<Role> findRoleByLibelle(String libelle);
}
