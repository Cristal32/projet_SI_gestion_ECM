package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Promo;
import com.example.projetSI.repository.PromoDao;
import com.example.projetSI.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDao promoDao;

    // ---------------------------- get all promos ----------------------------
    @Override
    public List<Promo> getAllPromos(){
        return promoDao.findAll();
    }

    // ---------------------------- get promo by their id ----------------------------
    @Override
    public Promo findPromoByAnnee(int annee) {
        return promoDao.findPromoByAnnee(annee).orElse(null);
    }

    // ---------------------------- add promo ----------------------------
    @Override
    public Promo addPromo(Promo promo) {
        return promoDao.save(promo);
    }

    // ---------------------------- update promo ----------------------------
    @Override
    public Promo updatePromo(Promo promo) {
        return promoDao.save(promo);
    }

    // ---------------------------- delete promo by id ----------------------------
    @Override
    public void deletePromo(int annee) {
        promoDao.deleteById(annee);
    }

}
