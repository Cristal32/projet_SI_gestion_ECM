package com.example.projetSI.service;

import com.example.projetSI.model.Prof;

import java.util.List;

public interface ProfService {
    public List<Prof> getAllProfs();
    public Prof findProfById(int id);
    public Prof addProf(Prof prof);
    public Prof updateProf(Prof prof);
    public void deleteProf(int id);
}
