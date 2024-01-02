package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Stage;

public interface StageService {
	public List<Stage> getAllStages();
	public Stage findStageById(int id);
	public Stage addStage(Stage stage);
	public Stage updateStage(Stage stage);
	public void deleteStage(int id);
}
