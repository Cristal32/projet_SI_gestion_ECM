package com.example.projetSI.controller;

import com.example.projetSI.model.Access;
import com.example.projetSI.model.Utilisateur;
import com.example.projetSI.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    //we will inject the user service here

    @Autowired
    private final UtilisateurService utilisateurService;

    //constructeur
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('GET_USERS')")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateur(){
        List<Utilisateur> users = utilisateurService.getAllUtilisateur();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
//    @PreAuthorize("hasAuthority('GET_USERS')")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") int id){
        Utilisateur user = utilisateurService.findUtilisateurById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllAccesByUserId/{id}")
//    @PreAuthorize("hasAuthority('GET_USERS')")
    public ResponseEntity<Set<Access>> getUtilisateurAccesses(@PathVariable("id") int id){
        Utilisateur user = utilisateurService.findUtilisateurById(id);
        Set<Access> userAccesses = utilisateurService.getUtilisateurAccesses(user);
        return new ResponseEntity<>(userAccesses,HttpStatus.OK);
    }

    // ================================= POST Mapping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('MANAGE_USERS')")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur user){
        Utilisateur newUtilisateur = utilisateurService.addUtilisateur(user);
        return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('MANAGE_USERS')")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur user){
        Utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(user);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_USERS')")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") int id){
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
