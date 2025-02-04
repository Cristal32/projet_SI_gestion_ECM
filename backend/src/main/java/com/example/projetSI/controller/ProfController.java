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

import com.example.projetSI.modal.Professeur;
import com.example.projetSI.service.ProfService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/prof")
public class ProfController {
	
	@Autowired
	private final ProfService profService;
	
	//constructeur
	public ProfController(ProfService profService) {
		this.profService = profService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Professeur>> getAllProfs(){
		List<Professeur> profs = profService.getAllProfs();
		return new ResponseEntity<>(profs, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Professeur> getProfById(@PathVariable("id") String id){
		Professeur prof = profService.findProfById(id);
		return new ResponseEntity<>(prof, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Professeur> addProf(@RequestBody Professeur prof){
		Professeur new_prof = profService.addProf(prof);
		return new ResponseEntity<>(new_prof, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Professeur> updateProf(@RequestBody Professeur prof){
		Professeur updated_prof = profService.updateProf(prof);
		return new ResponseEntity<>(updated_prof, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProf(@PathVariable("id") String id){
		profService.deleteProf(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
