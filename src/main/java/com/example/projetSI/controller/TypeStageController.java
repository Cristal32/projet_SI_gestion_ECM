package com.example.projetSI.controller;

import com.example.projetSI.model.Type_Stage;
import com.example.projetSI.service.TypeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeStage")
public class TypeStageController {
    @Autowired
    private final TypeStageService typeStageService;

    //constructeur
    public TypeStageController(TypeStageService typeStageService) {
        this.typeStageService = typeStageService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Type_Stage>> getAllTypesStage(){
        List<Type_Stage> types_stage = typeStageService.getAllTypesStage();
        return new ResponseEntity<>(types_stage, HttpStatus.OK);
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<Type_Stage> getTypeStageByCode(@PathVariable("code") String code){
        Type_Stage type_stage = typeStageService.findTypeStageByCode(code);
        return new ResponseEntity<>(type_stage, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
    public ResponseEntity<Type_Stage> addTypeStage(@RequestBody Type_Stage type_stage){
        Type_Stage new_type_stage = typeStageService.addTypeStage(type_stage);
        return new ResponseEntity<>(new_type_stage, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Type_Stage> updateTypeStage(@RequestBody Type_Stage type_stage){
        Type_Stage updated_type_stage = typeStageService.updateTypeStage(type_stage);
        return new ResponseEntity<>(updated_type_stage, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> deleteTypeStage(@PathVariable("code") String code){
        typeStageService.deleteTypeStage(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
