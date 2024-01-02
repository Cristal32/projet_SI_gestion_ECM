package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Tuteur;
import com.example.projetSI.repository.TuteurDao;
import com.example.projetSI.service.TuteurService;

@Service
public class TuteurServiceImpl implements TuteurService{
	
	@Autowired
	private TuteurDao tuteurDao;
	
	// ---------------------------- get all types stage ----------------------------
	@Override
	public List<Tuteur> getAllTuteurs(){
		return tuteurDao.findAll();
	}
		
	// ---------------------------- get type stage by their id ----------------------------
	@Override
	public Tuteur findTuteurById(int id) {
		return tuteurDao.findTuteurById(id).orElse(null);
	}
	
	// ---------------------------- add type stage ----------------------------
	@Override
	public Tuteur addTuteur(Tuteur tuteur) {
		return tuteurDao.save(tuteur);
	}
	
	// ---------------------------- update type stage ----------------------------
	@Override
	public Tuteur updateTuteur(Tuteur tuteur) {
		return tuteurDao.save(tuteur);
	}
	
	// ---------------------------- delete type stage by id ----------------------------
	@Override
	public void deleteTuteur(int id) {
		tuteurDao.deleteById(id);
	}

}
