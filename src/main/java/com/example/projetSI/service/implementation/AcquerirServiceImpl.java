package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Acquerir;
import com.example.projetSI.repository.AcquerirDao;
import com.example.projetSI.service.AcquerirService;

@Service
public class AcquerirServiceImpl implements AcquerirService {
	@Autowired
    private AcquerirDao acquerirDao;

 // ---------------------------- get all acquerirs  ----------------------------
    
    @Override
    public List<Acquerir> getAllAcquerirs() {
        return acquerirDao.findAll();
    }

 // ---------------------------- find acquerir ----------------------------
    
    @Override
    public Acquerir findAcquerirById(int typeStageId, String competenceId) {
    	Acquerir.AcquerirId id = new Acquerir.AcquerirId(typeStageId, competenceId);
        return acquerirDao.findAcquerirById(id).orElse(null);
    }

 // ---------------------------- add acquerir ----------------------------
    
    @Override
    public Acquerir addAcquerir(Acquerir acquerir) {
        return acquerirDao.save(acquerir);
    }

 // ---------------------------- update acquerir ----------------------------
    
    @Override
    public Acquerir updateAcquerir(Acquerir acquerir) {
        return acquerirDao.save(acquerir);
    }

 // ---------------------------- delete acquerir ----------------------------
    
    @Override
    public void deleteAcquerir(int typeStageId, String competenceId) {
        Acquerir.AcquerirId id = new Acquerir.AcquerirId(typeStageId, competenceId);
        acquerirDao.findAcquerirById(id);
    }
}
