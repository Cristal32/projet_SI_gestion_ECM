package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Type_Stage;
import com.example.projetSI.repository.TypeStageDao;
import com.example.projetSI.service.TypeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeStageServiceImpl implements TypeStageService {
    @Autowired
    private TypeStageDao typeStageDao;

    // ---------------------------- get all types stage ----------------------------
    @Override
    public List<Type_Stage> getAllTypesStage(){
        return typeStageDao.findAll();
    }

    // ---------------------------- get type stage by their id ----------------------------
    @Override
    public Type_Stage findTypeStageByCode(String code) {
        return typeStageDao.findTypeStageByCode(code).orElse(null);
    }

    // ---------------------------- add type stage ----------------------------
    @Override
    public Type_Stage addTypeStage(Type_Stage type_stage) {
        return typeStageDao.save(type_stage);
    }

    // ---------------------------- update type stage ----------------------------
    @Override
    public Type_Stage updateTypeStage(Type_Stage type_stage) {
        return typeStageDao.save(type_stage);
    }

    // ---------------------------- delete type stage by code ----------------------------
    @Override
    public void deleteTypeStage(String code) {
        typeStageDao.deleteById(code);
    }
}
