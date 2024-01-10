package com.example.projetSI.service;

import com.example.projetSI.model.Access;

import java.util.List;

public interface AccessService {
    public List<Access> getAllAccess();
    public Access findAccessById(int id);
    public Access findAccessByLibelle(String libelle);
    public Access saveAccess(Access access);
    public Access updateAccess(Access access);
    public void deleteAccess(int id);
}
