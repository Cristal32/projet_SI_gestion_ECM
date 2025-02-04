package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Stage;
import com.example.projetSI.repository.StageDao;
import com.example.projetSI.service.StageService;

@Service
public class StageServiceImpl implements StageService {
	
	@Autowired
	private StageDao stageDao;
	
	// ---------------------------- get all stages ----------------------------
	@Override
	public List<Stage> getAllStages(){
		return stageDao.findAll();
	}
		
	// ---------------------------- get stage by their id ----------------------------
	@Override
	public Stage findStageById(int id) {
		return stageDao.findStageById(id).orElse(null);
	}
	
	// ---------------------------- add stage ----------------------------
	@Override
	public Stage addStage(Stage stage) {
		return stageDao.save(stage);
	}
	
	// ---------------------------- update stage ----------------------------
	@Override
	public Stage updateStage(Stage stage) {
		return stageDao.save(stage);
	}
	
	// ---------------------------- delete stage by id ----------------------------
	@Override
	public void deleteStage(int id) {
		stageDao.deleteById(id);
	}
}
