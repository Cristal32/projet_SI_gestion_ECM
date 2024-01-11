package com.example.projetSI.controller;

import com.example.projetSI.model.Promo;
import com.example.projetSI.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promo")
public class PromoController {
    @Autowired
    private final PromoService promoService;

    //constructeur
    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('MANAGE_PROMOS')")
    public ResponseEntity<List<Promo>> getAllPromos(){
        List<Promo> promos = promoService.getAllPromos();
        return new ResponseEntity<>(promos, HttpStatus.OK);
    }

    @GetMapping("/get/{annee}")
//    @PreAuthorize("hasAuthority('MANAGE_PROMO')")
    public ResponseEntity<Promo> getPromoByAnneePromo(@PathVariable("annee") int annee){
        Promo promo = promoService.findPromoByAnnee(annee);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }
    // ================================= POST Mapping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('MANAGE_PROMO')")
    public ResponseEntity<Promo> addPromo(@RequestBody Promo promo){
        Promo new_promo = promoService.addPromo(promo);
        return new ResponseEntity<>(new_promo, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('MANAGE_PROMO')")
    public ResponseEntity<Promo> updatePromo(@RequestBody Promo promo){
        Promo updated_promo = promoService.updatePromo(promo);
        return new ResponseEntity<>(updated_promo, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{annee}")
//    @PreAuthorize("hasAuthority('MANAGE_PROMO')")
    public ResponseEntity<?> deletePromo(@PathVariable("annee") int annee){
        promoService.deletePromo(annee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
