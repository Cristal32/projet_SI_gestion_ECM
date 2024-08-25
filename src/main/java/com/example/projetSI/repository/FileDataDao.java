package com.example.projetSI.repository;

import com.example.projetSI.modal.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDataDao extends JpaRepository<FileData, Long> {
    Optional<FileData> findByFileName(String filename);
}