package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Professeur;
import com.example.projetSI.repository.ProfDao;
import com.example.projetSI.service.ProfService;

@Service
public class ProfServiceImpl implements ProfService{
	
	@Autowired
	private ProfDao profDao;
	
	// ---------------------------- get all profs ----------------------------
	@Override
	public List<Professeur> getAllProfs(){
		return profDao.findAll();
	}
		
	// ---------------------------- get prof by their id ----------------------------
	@Override
	public Professeur findProfById(String id) {
		return profDao.findProfById(id).orElse(null);
	}
	
	// ---------------------------- add prof ----------------------------
	@Override
	public Professeur addProf(Professeur prof) {
		return profDao.save(prof);
	}
	
	// ---------------------------- update prof ----------------------------
	@Override
	public Professeur updateProf(Professeur prof) {
		return profDao.save(prof);
	}
	
	// ---------------------------- delete prof by id ----------------------------
	@Override
	public void deleteProf(String id) {
		profDao.deleteProfById(id);
	}
}
