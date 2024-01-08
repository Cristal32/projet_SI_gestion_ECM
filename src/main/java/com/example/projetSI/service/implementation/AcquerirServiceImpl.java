package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Acquerir;
import com.example.projetSI.repository.AcquerirDao;
import com.example.projetSI.service.AcquerirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquerirServiceImpl implements AcquerirService {

    @Autowired
    private AcquerirDao acquerirDao;

    @Override
    public List<Acquerir> getAllAcquerirs() {
        return acquerirDao.findAll();
    }

    @Override
    public Acquerir findAcquerirById(Acquerir.AcquerirId id) {
        return acquerirDao.findAcquerirById(id).orElse(null);
    }

    @Override
    public Acquerir addAcquerir(Acquerir acquerir) {
        return acquerirDao.save(acquerir);
    }

    @Override
    public Acquerir updateAcquerir(Acquerir acquerir) {
        return acquerirDao.save(acquerir);
    }

    @Override
    public void deleteAcquerir(Acquerir.AcquerirId id) {
        acquerirDao.deleteById(id);
    }
}
