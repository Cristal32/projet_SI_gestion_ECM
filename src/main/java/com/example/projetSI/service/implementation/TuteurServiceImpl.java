package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Tuteur;
import com.example.projetSI.repository.TuteurDao;
import com.example.projetSI.service.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuteurServiceImpl implements TuteurService {

    @Autowired
    private TuteurDao tuteurDao;

    // ---------------------------- get all tuteurs ----------------------------
    @Override
    public List<Tuteur> getAllTuteurs(){
        return tuteurDao.findAll();
    }

    // ---------------------------- get tuteur by their id ----------------------------
    @Override
    public Tuteur findTuteurById(String id) {
        return tuteurDao.findTuteurById(id).orElse(null);
    }

    // ---------------------------- add tuteur ----------------------------
    @Override
    public Tuteur addTuteur(Tuteur tuteur) {
        return tuteurDao.save(tuteur);
    }

    // ---------------------------- update tuteur ----------------------------
    @Override
    public Tuteur updateTuteur(Tuteur tuteur) {
        return tuteurDao.save(tuteur);
    }

    // ---------------------------- delete tuteur by id ----------------------------
    @Override
    public void deleteTuteur(String id) {
        tuteurDao.deleteById(id);
    }

}
