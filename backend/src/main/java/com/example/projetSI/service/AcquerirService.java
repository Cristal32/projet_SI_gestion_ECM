package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Acquerir;

public interface AcquerirService {
	public List<Acquerir> getAllAcquerirs();
	public Acquerir findAcquerirById(int typeStageId, String competenceId);
	public Acquerir addAcquerir(Acquerir acquerir);
	public Acquerir updateAcquerir(Acquerir acquerir);
	public void deleteAcquerir(int typeStageId, String competenceId);
}
