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

import com.example.projetSI.modal.Entreprise;
import com.example.projetSI.service.EntrepriseService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/entreprise")
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
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") int id){
		Entreprise entreprise = entrepriseService.findEntrepriseById(id);
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEntreprise(@PathVariable("id") int id){
		entrepriseService.deleteEntreprise(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
