package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.DateStage;

public interface DateStageService {
	public List<DateStage> getAllDatesStage();
	public DateStage findDateStageById(int typeStageId, int anneeId);
	public DateStage addDateStage(DateStage dateStage);
	public DateStage updateDateStage(DateStage dateStage);
	public void deleteDateStage(int typeStageId, int anneeId);
}
