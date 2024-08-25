package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.TypeStage;

public interface TypeStageService {
	public List<TypeStage> getAllTypesStage();
	public TypeStage findTypeStageById(int id);
	public TypeStage addTypeStage(TypeStage type_stage);
	public TypeStage updateTypeStage(TypeStage type_stage);
	public void deleteTypeStage(int id);

}
