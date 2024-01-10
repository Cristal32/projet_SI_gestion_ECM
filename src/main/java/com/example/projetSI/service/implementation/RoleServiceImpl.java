package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Role;
import com.example.projetSI.repository.RoleDao;
import com.example.projetSI.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    // ---------------------------- find all roles ----------------------------
    @Override
    public List<Role> getAllRole(){
        return roleDao.findAll();
    }

    // ---------------------------- find a role by their id ----------------------------
    @Override
    public Role findRoleById(int id) {
        return roleDao.findRoleById(id).orElse(null);
    }

    // ---------------------------- find a role by their libelle ----------------------------
    @Override
    public Role findRoleByLibelle(String libelle) {
        return roleDao.findRoleByLibelle(libelle).orElse(null);
    }

    // ---------------------------- add a role ----------------------------
    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    // ---------------------------- update a role ----------------------------
    @Override
    public Role updateRole(Role role) {
        return roleDao.save(role);
    }

    // ---------------------------- delete a role by their id ----------------------------
    @Override
    public void deleteRole(int id) {
        roleDao.deleteRoleById(id);
    }
}
