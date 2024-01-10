package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Access;
import com.example.projetSI.repository.AccessDao;
import com.example.projetSI.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessDao accessDao;

    // ---------------------------- find all accesses ----------------------------
    @Override
    public List<Access> getAllAccess(){
        return accessDao.findAll();
    }

    // ---------------------------- find an access by their id ----------------------------
    @Override
    public Access findAccessById(int id) {
        return accessDao.findAccessById(id).orElse(null);
    }

    // ---------------------------- find a role by their libelle ----------------------------
    @Override
    public Access findAccessByLibelle(String libelle) {
        return accessDao.findAccessByLibelle(libelle).orElse(null);
    }

    // ---------------------------- add an access ----------------------------
    @Override
    public Access saveAccess(Access access) {
        return accessDao.save(access);
    }

    // ---------------------------- update an access ----------------------------
    @Override
    public Access updateAccess(Access access) {
        return accessDao.save(access);
    }

    // ---------------------------- delete an access by their id ----------------------------
    @Override
    public void deleteAccess(int id) {
        accessDao.deleteAccessById(id);
    }
}
