package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.TypeStage;
import com.example.projetSI.repository.TypeStageDao;
import com.example.projetSI.service.TypeStageService;

@Service
public class TypeStageServiceImpl implements TypeStageService {
	
	@Autowired
	private TypeStageDao typeStageDao;
	
	// ---------------------------- get all types stage ----------------------------
	@Override
	public List<TypeStage> getAllTypesStage(){
		return typeStageDao.findAll();
	}
		
	// ---------------------------- get type stage by their id ----------------------------
	@Override
	public TypeStage findTypeStageById(int id) {
		return typeStageDao.findTypeStageById(id).orElse(null);
	}
	
	// ---------------------------- add type stage ----------------------------
	@Override
	public TypeStage addTypeStage(TypeStage type_stage) {
		return typeStageDao.save(type_stage);
	}
	
	// ---------------------------- update type stage ----------------------------
	@Override
	public TypeStage updateTypeStage(TypeStage type_stage) {
		return typeStageDao.save(type_stage);
	}
	
	// ---------------------------- delete type stage by id ----------------------------
	@Override
	public void deleteTypeStage(int id) {
		typeStageDao.deleteById(id);
	}

}
