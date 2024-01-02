package com.example.projetSI.repository;

import com.example.projetSI.model.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromoDao extends JpaRepository<Promo, Integer> {
    Optional<Promo> findPromoByAnnee(int annee);
}
