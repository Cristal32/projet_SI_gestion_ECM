package com.example.projetSI.controller;

import com.example.projetSI.model.Etudiant;
import com.example.projetSI.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/etudiant")
public class EtudiantController {

    @Autowired
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('GET_ETUDIANTS')")
    public ResponseEntity<List<Etudiant>> getAllEtudiants(){
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Etudiant> getAccessById(@PathVariable("id") int id){
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADD_ETUDIANT')")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('UPDATE_ETUDIANT')")
    public ResponseEntity<Etudiant> updateAccess(@RequestBody Etudiant etudiant){
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('DELETE_ETUDIANT')")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") int id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
