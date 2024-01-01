package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Entreprise;
import com.example.projetSI.repository.EntrepriseDao;
import com.example.projetSI.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	@Autowired
	private EntrepriseDao entrepriseDao;
	
	// ---------------------------- get all entreprises ----------------------------
	@Override
	public List<Entreprise> getAllEntreprises(){
		return entrepriseDao.findAll();
	}
		
	// ---------------------------- get entreprise by their id ----------------------------
	@Override
	public Entreprise findEntrepriseById(int id) {
		return entrepriseDao.findEntrepriseById(id).orElse(null);
	}
	
	// ---------------------------- add entreprise ----------------------------
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		return entrepriseDao.save(entreprise);
	}
	
	// ---------------------------- update entreprise ----------------------------
	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		return entrepriseDao.save(entreprise);
	}
	
	// ---------------------------- delete entreprise by id ----------------------------
	@Override
	public void deleteEntreprise(int id) {
		entrepriseDao.deleteById(id);
	}
}
