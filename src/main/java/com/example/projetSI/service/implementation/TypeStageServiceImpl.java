package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Etudiant;
import com.example.projetSI.modal.TypeStage;
import com.example.projetSI.repository.TypeStageDao;
import com.example.projetSI.service.TypeStageService;

@Service
public class TypeStageServiceImpl implements TypeStageService {
	
	@Autowired
	private TypeStageDao typeStageDao;
	
	// ---------------------------- get all etudiants ----------------------------
	@Override
	public List<TypeStage> getAllTypesStage(){
		return typeStageDao.findAll();
	}
		
	// ---------------------------- get etudiant by their id ----------------------------
	@Override
	public TypeStage findTypeStageById(int id) {
		return typeStageDao.findTypeStageById(id).orElse(null);
	}
	
	// ---------------------------- add etudiant ----------------------------
	@Override
	public TypeStage addTypeStage(TypeStage type_stage) {
		return typeStageDao.save(type_stage);
	}
	
	// ---------------------------- update etudiant ----------------------------
	@Override
	public TypeStage updateTypeStage(TypeStage type_stage) {
		return typeStageDao.save(type_stage);
	}
	
	// ---------------------------- delete stagiaire by id ----------------------------
	@Override
	public void deleteTypeStage(int id) {
		typeStageDao.deleteById(id);
	}

}
