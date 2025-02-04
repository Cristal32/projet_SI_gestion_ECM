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

import com.example.projetSI.modal.Promo;
import com.example.projetSI.service.PromoService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
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
	public ResponseEntity<List<Promo>> getAllPromos(){
		List<Promo> promos = promoService.getAllPromos();
		return new ResponseEntity<>(promos, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Promo> getPromoById(@PathVariable("id") int id){
		Promo promo = promoService.findPromoById(id);
		return new ResponseEntity<>(promo, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Promo> addPromo(@RequestBody Promo promo){
		Promo new_promo = promoService.addPromo(promo);
		return new ResponseEntity<>(new_promo, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Promo> updatePromo(@RequestBody Promo promo){
		Promo updated_promo = promoService.updatePromo(promo);
		return new ResponseEntity<>(updated_promo, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePromo(@PathVariable("id") int id){
		promoService.deletePromo(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
}
