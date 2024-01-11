package com.example.projetSI.controller;

import com.example.projetSI.model.Acquerir;
import com.example.projetSI.service.AcquerirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acquerir")
public class AcquerirController {

    @Autowired
    private final AcquerirService acquerirService;

    public AcquerirController(AcquerirService acquerirService) {
        this.acquerirService = acquerirService;
    }

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('GET_ALL_ACQUERIRS')")
    public ResponseEntity<List<Acquerir>> getAllAcquerirs(){
        List<Acquerir> acquerirs = acquerirService.getAllAcquerirs();
        return new ResponseEntity<>(acquerirs, HttpStatus.OK);
    }

    @GetMapping("/get/{typeStageId}/{competenceId}")
//    @PreAuthorize("hasAuthority('GET_ACQUERIR')")
    public ResponseEntity<Acquerir> getAcquerirById(@PathVariable String typeStageId, @PathVariable String competenceId){
        Acquerir.AcquerirId id = new Acquerir.AcquerirId(typeStageId, competenceId);
        Acquerir acquerir = acquerirService.findAcquerirById(id);
        return new ResponseEntity<>(acquerir, HttpStatus.OK);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADD_ACQUERIR')")
    public ResponseEntity<Acquerir> addAcquerir(@RequestBody Acquerir acquerir) {
        Acquerir new_acquerir = acquerirService.addAcquerir(acquerir);
        return new ResponseEntity<>(new_acquerir, HttpStatus.CREATED);
    }

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('UPDATE_ACQUERIR')")
    public ResponseEntity<Acquerir> updateAcquerir(@RequestBody Acquerir acquerir) {
        Acquerir acquerir_updated = acquerirService.updateAcquerir(acquerir);
        return new ResponseEntity<>(acquerir_updated, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{typeStageId}/{competenceId}")
//    @PreAuthorize("hasAuthority('DELETE_ACQUERIR')")
    public ResponseEntity<Void> deleteAcquerir(@PathVariable String typeStageId, @PathVariable String competenceId) {
        Acquerir.AcquerirId id = new Acquerir.AcquerirId(typeStageId, competenceId);
        acquerirService.deleteAcquerir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
