package com.example.projetSI.controller;

import com.example.projetSI.model.Stage;
import com.example.projetSI.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/api/stage")
public class StageController {

    @Autowired
    private final StageService stageService;

    //constructeur
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Stage>> getAllStages(){
        List<Stage> etudiants = stageService.getAllStages();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Stage> getStageById(@PathVariable("id") int id){
        Stage stage = stageService.findStageById(id);
        return new ResponseEntity<>(stage, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
    public ResponseEntity<Stage> addStage(@RequestBody Stage stage){
        Stage newStage = stageService.addStage(stage);
        return new ResponseEntity<>(newStage, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Stage> updateStage(@RequestBody Stage stage){
        Stage updatedStage = stageService.updateStage(stage);
        return new ResponseEntity<>(updatedStage, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") int id){
        stageService.deleteStage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
