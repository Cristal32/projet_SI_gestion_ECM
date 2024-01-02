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

import com.example.projetSI.modal.TypeStage;
import com.example.projetSI.service.TypeStageService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/typeStage")
public class TypeStageController {
	@Autowired
	private final TypeStageService typeStageService;
	
	//constructeur
	public TypeStageController(TypeStageService typeStageService) {
		this.typeStageService = typeStageService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TypeStage>> getAllTypesStage(){
		List<TypeStage> types_stage = typeStageService.getAllTypesStage();
		return new ResponseEntity<>(types_stage, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TypeStage> getTypeStageById(@PathVariable("id") int id){
		TypeStage type_stage = typeStageService.findTypeStageById(id);
		return new ResponseEntity<>(type_stage, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<TypeStage> addTypeStage(@RequestBody TypeStage type_stage){
		TypeStage new_type_stage = typeStageService.addTypeStage(type_stage);
		return new ResponseEntity<>(new_type_stage, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<TypeStage> updateTypeStage(@RequestBody TypeStage type_stage){
		TypeStage updated_type_stage = typeStageService.updateTypeStage(type_stage);
		return new ResponseEntity<>(updated_type_stage, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTypeStage(@PathVariable("id") int id){
		typeStageService.deleteTypeStage(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
