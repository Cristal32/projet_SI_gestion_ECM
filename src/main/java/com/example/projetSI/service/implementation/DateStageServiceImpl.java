package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.DateStage;
import com.example.projetSI.repository.DateStageDao;
import com.example.projetSI.service.DateStageService;

@Service
public class DateStageServiceImpl implements DateStageService {
	
	@Autowired
    private DateStageDao dateStageDao;

 // ---------------------------- get all date stage  ----------------------------
    
    @Override
    public List<DateStage> getAllDatesStage() {
        return dateStageDao.findAll();
    }

 // ---------------------------- find date stage ----------------------------
    
    @Override
    public DateStage findDateStageById(int typeStageId, int anneeId) {
    	DateStage.DateStageId id = new DateStage.DateStageId(typeStageId, anneeId);
        return dateStageDao.findDateStageById(id).orElse(null);
    }

 // ---------------------------- add date stage ----------------------------
    
    @Override
    public DateStage addDateStage(DateStage dateStage) {
        return dateStageDao.save(dateStage);
    }

 // ---------------------------- update date stage ----------------------------
    
    @Override
    public DateStage updateDateStage(DateStage dateStage) {
        return dateStageDao.save(dateStage);
    }

 // ---------------------------- delete date stage ----------------------------
    
    @Override
    public void deleteDateStage(int typeStageId, int anneeId) {
    	DateStage.DateStageId id = new DateStage.DateStageId(typeStageId, anneeId);
        dateStageDao.findDateStageById(id);
    }
}
