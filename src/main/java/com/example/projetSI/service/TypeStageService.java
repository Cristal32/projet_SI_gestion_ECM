package com.example.projetSI.service;

import com.example.projetSI.model.Type_Stage;

import java.util.List;

public interface TypeStageService {
    public List<Type_Stage> getAllTypesStage();
    public Type_Stage findTypeStageByCode(String code);
    public Type_Stage addTypeStage(Type_Stage type_stage);
    public Type_Stage updateTypeStage(Type_Stage type_stage);
    public void deleteTypeStage(String code);
}
