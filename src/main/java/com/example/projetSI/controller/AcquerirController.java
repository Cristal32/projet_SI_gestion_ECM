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

import com.example.projetSI.modal.Acquerir;
import com.example.projetSI.service.AcquerirService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/acquerir")
public class AcquerirController {
	
	@Autowired
	private final AcquerirService acquerirService;
	
	//constructeur
	public AcquerirController(AcquerirService acquerirService) {
		this.acquerirService = acquerirService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Acquerir>> getAllAcquerirs(){
		List<Acquerir> acquerirs = acquerirService.getAllAcquerirs();
		return new ResponseEntity<>(acquerirs, HttpStatus.OK);
	}
	
	@GetMapping("/get/{typeStageId}/{competenceId}")
	public ResponseEntity<Acquerir> getEtudiantById(@PathVariable int typeStageId, @PathVariable String competenceId){
		Acquerir acquerir = acquerirService.findAcquerirById(typeStageId, competenceId);
		return new ResponseEntity<>(acquerir, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Acquerir> addAcquerir(@RequestBody Acquerir acquerir){
		Acquerir new_acquerir = acquerirService.addAcquerir(acquerir);
		return new ResponseEntity<>(new_acquerir, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Acquerir> updateAcquerir(@RequestBody Acquerir acquerir){
		Acquerir updated_acquerir = acquerirService.updateAcquerir(acquerir);
		return new ResponseEntity<>(updated_acquerir, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{typeStageId}/{competenceId}")
	public ResponseEntity<?> deleteAcquerir(@PathVariable int typeStageId, @PathVariable String competenceId){
		acquerirService.deleteAcquerir(typeStageId, competenceId);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
