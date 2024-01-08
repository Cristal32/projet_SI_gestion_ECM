package com.example.projetSI.service;

import com.example.projetSI.model.Candidat;
import com.example.projetSI.model.FileData;
import com.example.projetSI.model.Promo;

import java.util.List;

public interface CandidatService {
    public List<Candidat> getAllCandidats();
    public Candidat findCandidatByEmail(String email);
    public Candidat addCandidat(Candidat candidat);
    public Candidat updateCandidat(Candidat candidat);
    public void deleteCandidat(String email);
}
