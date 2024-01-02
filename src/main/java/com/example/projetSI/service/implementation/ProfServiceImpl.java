package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Prof;
import com.example.projetSI.repository.ProfDao;
import com.example.projetSI.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfServiceImpl implements ProfService {
    @Autowired
    private ProfDao profDao;

    // ---------------------------- get all profs ----------------------------
    @Override
    public List<Prof> getAllProfs(){
        return profDao.findAll();
    }

    // ---------------------------- get prof by their id ----------------------------
    @Override
    public Prof findProfById(int id) {
        return profDao.findProfById(id).orElse(null);
    }

    // ---------------------------- add prof ----------------------------
    @Override
    public Prof addProf(Prof prof) {
        return profDao.save(prof);
    }

    // ---------------------------- update prof ----------------------------
    @Override
    public Prof updateProf(Prof prof) {
        return profDao.save(prof);
    }

    // ---------------------------- delete prof by id ----------------------------
    @Override
    public void deleteProf(int id) {
        profDao.deleteById(id);
    }
}
