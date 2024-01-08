package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Candidat;
import com.example.projetSI.model.FileData;
import com.example.projetSI.model.Promo;
import com.example.projetSI.repository.CandidatDao;
import com.example.projetSI.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.spi.CalendarNameProvider;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatDao candidatDao;

    @Override
    public List<Candidat> getAllCandidats() {
        return candidatDao.findAll();
    }

    @Override
    public Candidat findCandidatByEmail(String email) {
        return candidatDao.findCandidatByEmail(email).orElse(null);
    }

    @Override
    public Candidat addCandidat(Candidat candidat) {
        return candidatDao.save(candidat);
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        return candidatDao.save(candidat);
    }

    @Override
    public void deleteCandidat(String email) {
        candidatDao.deleteById(email);
    }
}
