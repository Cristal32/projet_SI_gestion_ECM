package com.example.projetSI.service;

import com.example.projetSI.model.Stage;

import java.util.List;

public interface StageService {
    public List<Stage> getAllStages();
    public Stage findStageById(int id);
    public Stage addStage(Stage stage);
    public Stage updateStage(Stage stage);
    public void deleteStage(int id);
    public List<Stage> getStagesByEtudiantId(int etudiantId);
}
