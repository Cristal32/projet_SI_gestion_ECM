package com.example.projetSI.service.implementation;

import com.example.projetSI.modal.Candidat;
import com.example.projetSI.repository.CandidatDao;
import com.example.projetSI.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatDao candidatDao;

 // ---------------------------- get all candidats ----------------------------
    
    @Override
    public List<Candidat> getAllCandidats() {
        return candidatDao.findAll();
    }

 // ---------------------------- find candidat ----------------------------
    
    @Override
    public Candidat findCandidatByEmail(String email) {
        return candidatDao.findCandidatByEmail(email).orElse(null);
    }

 // ---------------------------- add candidat ----------------------------
    
    @Override
    public Candidat addCandidat(Candidat candidat) {
        return candidatDao.save(candidat);
    }

 // ---------------------------- update candidat ----------------------------
    
    @Override
    public Candidat updateCandidat(Candidat candidat) {
        return candidatDao.save(candidat);
    }

 // ---------------------------- delete candidat ----------------------------
    
    @Override
    public void deleteCandidat(String email) {
        candidatDao.deleteById(email);
    }
}
