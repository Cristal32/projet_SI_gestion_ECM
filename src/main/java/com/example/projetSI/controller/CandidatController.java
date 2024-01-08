package com.example.projetSI.controller;


import com.example.projetSI.model.Candidat;
import com.example.projetSI.model.FileData;
import com.example.projetSI.model.Promo;
import com.example.projetSI.service.CandidatService;
import com.example.projetSI.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/candidat")
public class CandidatController {
    @Autowired
    private final CandidatService candidatService;

    @Autowired
    private final StorageService storageService;

    public CandidatController(CandidatService candidatService, StorageService storageService) {
        this.storageService = storageService;
        this.candidatService = candidatService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
    public ResponseEntity<List<Candidat>> getAllCandidats(){
        List<Candidat> candidats = candidatService.getAllCandidats();
        // Filter out candidates with 'refused' and 'accepted' statuses
        List<Candidat> filteredCandidats = candidats.stream()
                .filter(candidat -> !("Refused".equals(candidat.getStatut()) || "Accepted".equals(candidat.getStatut())))
                .collect(Collectors.toList());
        return new ResponseEntity<>(filteredCandidats, HttpStatus.OK);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<Candidat> getAccessByEmail(@PathVariable("email") String email){
        Candidat candidat = candidatService.findCandidatByEmail(email);
        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping(value = "/add")
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat){
        Candidat newCandidat = candidatService.addCandidat(candidat);
        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addCandidatWithDossier", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addCandidatWithDossier(@RequestPart("candidatData") Candidat candidat, @RequestPart("dossier") MultipartFile dossier) throws IOException {
        try {
            if(dossier != null && !dossier.isEmpty()) {
                FileData uploadFile = storageService.uploadFile(dossier);
                candidat.setDossier(uploadFile);
            }
            Candidat newCandidat = candidatService.addCandidat(candidat);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidat created : " + newCandidat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error : " + e.getMessage());
        }
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
    public ResponseEntity<Candidat> updateAccess(@RequestBody Candidat candidat){
        Candidat updatedCandidat = candidatService.updateCandidat(candidat);
        return new ResponseEntity<>(updatedCandidat, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteCandidat(@PathVariable("email") String email){
        candidatService.deleteCandidat(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
