package com.example.projetSI.controller;

import com.example.projetSI.model.Prof;
import com.example.projetSI.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prof")
public class ProfController {
    @Autowired
    private final ProfService profService;

    //constructeur
    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Prof>> getAllProfs(){
        List<Prof> profs = profService.getAllProfs();
        return new ResponseEntity<>(profs, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Prof> getProfById(@PathVariable("id") int id){
        Prof prof = profService.findProfById(id);
        return new ResponseEntity<>(prof, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
    public ResponseEntity<Prof> addProf(@RequestBody Prof prof){
        Prof new_prof = profService.addProf(prof);
        return new ResponseEntity<>(new_prof, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Prof> updateProf(@RequestBody Prof prof){
        Prof updated_prof = profService.updateProf(prof);
        return new ResponseEntity<>(updated_prof, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProf(@PathVariable("id") int id){
        profService.deleteProf(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
