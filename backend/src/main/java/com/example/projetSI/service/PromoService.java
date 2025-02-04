package com.example.projetSI.service;

import java.util.List;

import com.example.projetSI.modal.Promo;

public interface PromoService {
	
	public List<Promo> getAllPromos();
	public Promo findPromoById(int id);
	public Promo addPromo(Promo promo);
	public Promo updatePromo(Promo promo);
	public void deletePromo(int id);

}
