package com.example.projetSI.controller;

import com.example.projetSI.model.Entreprise;
import com.example.projetSI.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entreprise")
public class EntrepriseController {
    @Autowired
    private final EntrepriseService entrepriseService;

    //constructeur
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Entreprise>> getAllEntreprises(){
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
        return new ResponseEntity<>(entreprises, HttpStatus.OK);
    }

    @GetMapping("/get/{siret}")
    public ResponseEntity<Entreprise> getEntrepriseBySiret(@PathVariable("siret") String siret){
        Entreprise entreprise = entrepriseService.findEntrepriseBySiret(siret);
        return new ResponseEntity<>(entreprise, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
    public ResponseEntity<Entreprise> addEntreprise(@RequestBody Entreprise entreprise){
        Entreprise new_entreprise = entrepriseService.addEntreprise(entreprise);
        return new ResponseEntity<>(new_entreprise, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise){
        Entreprise updated_entreprise = entrepriseService.updateEntreprise(entreprise);
        return new ResponseEntity<>(updated_entreprise, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{siret}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable("siret") String siret){
        entrepriseService.deleteEntreprise(siret);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
