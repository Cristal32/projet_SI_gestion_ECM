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

import com.example.projetSI.modal.DateStage;
import com.example.projetSI.service.DateStageService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/dateStage")
public class DateStageController {
	
	@Autowired
	private final DateStageService dateStageService;
	
	//constructeur
	public DateStageController(DateStageService dateStageService) {
		this.dateStageService = dateStageService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DateStage>> getAllDatesStage(){
		List<DateStage> dates_stage = dateStageService.getAllDatesStage();
		return new ResponseEntity<>(dates_stage, HttpStatus.OK);
	}
	
	@GetMapping("/get/{typeStageId}/{anneeId}")
	public ResponseEntity<DateStage> getDateStageById(@PathVariable int typeStageId, @PathVariable int anneeId){
		DateStage date_stage = dateStageService.findDateStageById(typeStageId, anneeId);
		return new ResponseEntity<>(date_stage, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<DateStage> addDateStage(@RequestBody DateStage date_stage){
		DateStage new_date_stage = dateStageService.addDateStage(date_stage);
		return new ResponseEntity<>(new_date_stage, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<DateStage> updateDateStage(@RequestBody DateStage date_stage){
		DateStage updated_date_stage = dateStageService.updateDateStage(date_stage);
		return new ResponseEntity<>(updated_date_stage, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{typeStageId}/{anneeId}")
	public ResponseEntity<?> deleteDateStage(@PathVariable int typeStageId, @PathVariable int anneeId){
		dateStageService.deleteDateStage(typeStageId, anneeId);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
}
