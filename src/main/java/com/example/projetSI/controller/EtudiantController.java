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

import com.example.projetSI.modal.Etudiant;
import com.example.projetSI.service.EtudiantService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/etudiant")
public class EtudiantController {
	
	@Autowired
	private final EtudiantService etudiantService;
	
	//constructeur
	public EtudiantController(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Etudiant>> getAllEtudiants(){
		List<Etudiant> etudiants = etudiantService.getAllEtudiants();
		return new ResponseEntity<>(etudiants, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") int id){
		Etudiant etudiant = etudiantService.findEtudiantById(id);
		return new ResponseEntity<>(etudiant, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
		Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
		return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
		return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable("id") int id){
		etudiantService.deleteEtudiant(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}

}
