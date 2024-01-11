package com.example.projetSI.controller;

import com.example.projetSI.model.Tuteur;
import com.example.projetSI.service.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tuteur")
public class TuteurController {

    @Autowired
    private final TuteurService tuteurService;

    //constructeur
    public TuteurController(TuteurService tuteurService) {
        this.tuteurService = tuteurService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('MANAGE_TUTEURS')")
    public ResponseEntity<List<Tuteur>> getAllTuteurs(){
        List<Tuteur> tuteurs = tuteurService.getAllTuteurs();
        return new ResponseEntity<>(tuteurs, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_TUTEUR')")
    public ResponseEntity<Tuteur> getTuteurById(@PathVariable("id") String id){
        Tuteur tuteur = tuteurService.findTuteurById(id);
        return new ResponseEntity<>(tuteur, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('MANAGE_TUTEUR')")
    public ResponseEntity<Tuteur> addTuteur(@RequestBody Tuteur tuteur){
        Tuteur new_tuteur = tuteurService.addTuteur(tuteur);
        return new ResponseEntity<>(new_tuteur, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('MANAGE_TUTEUR')")
    public ResponseEntity<Tuteur> updateTuteur(@RequestBody Tuteur tuteur){
        Tuteur updated_tuteur = tuteurService.updateTuteur(tuteur);
        return new ResponseEntity<>(updated_tuteur, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_TUTEUR')")
    public ResponseEntity<?> deleteTuteur(@PathVariable("id") String id){
        tuteurService.deleteTuteur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
