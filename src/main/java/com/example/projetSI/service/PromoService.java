package com.example.projetSI.service;

import com.example.projetSI.model.Promo;

import java.util.List;

public interface PromoService {
    public List<Promo> getAllPromos();
    public Promo findPromoByAnnee(int annee);
    public Promo addPromo(Promo promo);
    public Promo updatePromo(Promo promo);
    public void deletePromo(int annee);
}
