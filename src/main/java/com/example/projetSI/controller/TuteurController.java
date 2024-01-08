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

import com.example.projetSI.modal.Tuteur;
import com.example.projetSI.service.TuteurService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
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
	public ResponseEntity<List<Tuteur>> getAllTuteurs(){
		List<Tuteur> tuteurs = tuteurService.getAllTuteurs();
		return new ResponseEntity<>(tuteurs, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Tuteur> getTuteurById(@PathVariable("id") int id){
		Tuteur tuteur = tuteurService.findTuteurById(id);
		return new ResponseEntity<>(tuteur, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Tuteur> addTuteur(@RequestBody Tuteur tuteur){
		Tuteur new_tuteur = tuteurService.addTuteur(tuteur);
		return new ResponseEntity<>(new_tuteur, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Tuteur> updateTuteur(@RequestBody Tuteur tuteur){
		Tuteur updated_tuteur = tuteurService.updateTuteur(tuteur);
		return new ResponseEntity<>(updated_tuteur, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTuteur(@PathVariable("id") int id){
		tuteurService.deleteTuteur(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
