package com.example.projetSI.controller;

import com.example.projetSI.model.Access;
import com.example.projetSI.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/access")
public class AccessController {

    @Autowired
    private final AccessService accessService;

    //constructeur
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<List<Access>> getAllAccess(){
        List<Access> accesses = accessService.getAllAccess();
        return new ResponseEntity<>(accesses, HttpStatus.OK);
    }

    @GetMapping("/get/{libelle}")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<Access> getAccessById(@PathVariable("libelle") String libelle){
        Access access = accessService.findAccessByLibelle(libelle);
        return new ResponseEntity<>(access, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<Access> getAccessById(@PathVariable("id") int id){
        Access access = accessService.findAccessById(id);
        return new ResponseEntity<>(access, HttpStatus.OK);
    }

    // ================================= POST Mapping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<Access> addAccess(@RequestBody Access access){
        Access newAccess = accessService.saveAccess(access);
        return new ResponseEntity<>(newAccess, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<Access> updateAccess(@RequestBody Access access){
        Access updatedAccess = accessService.updateAccess(access);
        return new ResponseEntity<>(updatedAccess, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_ACCES')")
    public ResponseEntity<?> deleteAccess(@PathVariable("id") int id){
        accessService.deleteAccess(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
