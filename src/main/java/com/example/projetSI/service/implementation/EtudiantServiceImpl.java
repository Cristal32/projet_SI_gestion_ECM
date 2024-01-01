package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Etudiant;
import com.example.projetSI.repository.EtudiantDao;
import com.example.projetSI.service.EtudiantService;


@Service
public class EtudiantServiceImpl implements EtudiantService{
	
	@Autowired
	private EtudiantDao etudiantDao;
	
	// ---------------------------- get all etudiants ----------------------------
		@Override
		public List<Etudiant> getAllEtudiants(){
			return etudiantDao.findAll();
		}
		
	// ---------------------------- get etudiant by their id ----------------------------
	@Override
	public Etudiant findEtudiantById(int id) {
		return etudiantDao.findEtudiantById(id).orElse(null);
	}
	
	// ---------------------------- add stagiaire ----------------------------
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		return etudiantDao.save(etudiant);
	}
	
	// ---------------------------- update etudiant ----------------------------
	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantDao.save(etudiant);
	}
	
	// ---------------------------- delete stagiaire by id ----------------------------
	@Override
	public void deleteEtudiant(int id) {
		etudiantDao.deleteById(id);
	}

}
