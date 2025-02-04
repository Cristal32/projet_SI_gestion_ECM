package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Competence;
import com.example.projetSI.repository.CompetenceDao;
import com.example.projetSI.service.CompetenceService;

@Service
public class CompetenceServiceImpl implements CompetenceService {
	
	@Autowired
    private CompetenceDao competenceDao;

    @Override
    public List<Competence> getAllCompetences() {
        return competenceDao.findAll();
    }

    @Override
    public Competence findCompetenceByCode(String code) {
        return competenceDao.findCompetenceByCode(code).orElse(null);
    }

    @Override
    public Competence addCompetence(Competence competence) {
        return competenceDao.save(competence);
    }

    @Override
    public Competence updateCompetence(Competence competence) {
        return competenceDao.save(competence);
    }

    @Override
    public void deleteCompetence(String code) {
        competenceDao.deleteCompetenceByCode(code);
    }
}
