package com.example.projetSI.service;

import com.example.projetSI.modal.Candidat;

import java.util.List;

public interface CandidatService {
    public List<Candidat> getAllCandidats();
    public Candidat findCandidatByEmail(String email);
    public Candidat addCandidat(Candidat candidat);
    public Candidat updateCandidat(Candidat candidat);
    public void deleteCandidat(String email);
}
