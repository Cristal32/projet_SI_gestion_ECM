package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Entreprise;
import com.example.projetSI.repository.EntrepriseDao;
import com.example.projetSI.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseDao entrepriseDao;

    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseDao.findAll();
    }

    @Override
    public Entreprise findEntrepriseBySiret(String siret) {
        return entrepriseDao.findEntrepriseBySiret(siret).orElse(null);
    }

    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {
        return entrepriseDao.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise entreprise) {
        return entrepriseDao.save(entreprise);
    }

    @Override
    public void deleteEntreprise(String siret) {
        entrepriseDao.deleteById(siret);
    }
}
