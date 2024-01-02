package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Etudiant;
import com.example.projetSI.repository.EtudiantDao;
import com.example.projetSI.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantDao.findAll();
    }

    @Override
    public Etudiant findEtudiantById(int id) {
        return etudiantDao.findEtudiantById(id).orElse(null);
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    @Override
    public void deleteEtudiant(int id) {
        etudiantDao.deleteById(id);
    }
}
