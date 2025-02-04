package com.example.projetSI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetSI.modal.Competence;
import com.example.projetSI.service.CompetenceService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/competence")
public class CompetenceController {
	@Autowired
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Competence>> getAllCompetences(){
        List<Competence> competences = competenceService.getAllCompetences();
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<Competence> getAccessByCode(@PathVariable("code") String code){
        Competence competence = competenceService.findCompetenceByCode(code);
        return new ResponseEntity<>(competence, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
    public ResponseEntity<Competence> addCompetence(@RequestBody Competence competence){
        Competence newCompetence = competenceService.addCompetence(competence);
        return new ResponseEntity<>(newCompetence, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Competence> updateAccess(@RequestBody Competence competence){
        Competence updatedCompetence = competenceService.updateCompetence(competence);
        return new ResponseEntity<>(updatedCompetence, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> deleteCompetence(@PathVariable("code") String code){
        competenceService.deleteCompetence(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
