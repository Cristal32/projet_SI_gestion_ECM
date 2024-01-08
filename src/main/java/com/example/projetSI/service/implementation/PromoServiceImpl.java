package com.example.projetSI.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSI.modal.Promo;
import com.example.projetSI.repository.PromoDao;
import com.example.projetSI.service.PromoService;

@Service
public class PromoServiceImpl implements PromoService {
	
	@Autowired
	private PromoDao promoDao;
	
	// ---------------------------- get all stages ----------------------------
	@Override
	public List<Promo> getAllPromos(){
		return promoDao.findAll();
	}
		
	// ---------------------------- get stage by their id ----------------------------
	@Override
	public Promo findPromoById(int id) {
		return promoDao.findPromoById(id).orElse(null);
	}
	
	// ---------------------------- add stage ----------------------------
	@Override
	public Promo addPromo(Promo promo) {
		return promoDao.save(promo);
	}
	
	// ---------------------------- update stage ----------------------------
	@Override
	public Promo updatePromo(Promo promo) {
		return promoDao.save(promo);
	}
	
	// ---------------------------- delete stage by id ----------------------------
	@Override
	public void deletePromo(int id) {
		promoDao.deleteById(id);
	}
	
}
