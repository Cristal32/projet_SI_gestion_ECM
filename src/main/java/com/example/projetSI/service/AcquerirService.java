package com.example.projetSI.service;

import com.example.projetSI.model.Acquerir;

import java.util.List;

public interface AcquerirService {
    public List<Acquerir> getAllAcquerirs();
    public Acquerir findAcquerirById(Acquerir.AcquerirId id);
    public Acquerir addAcquerir(Acquerir acquerir);
    public Acquerir updateAcquerir(Acquerir acquerir);
    public void deleteAcquerir(Acquerir.AcquerirId id);
}
