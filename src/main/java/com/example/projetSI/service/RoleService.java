package com.example.projetSI.service;

import com.example.projetSI.model.Role;

import java.util.List;

public interface RoleService {
    public Role saveRole(Role role);
    public List<Role> getAllRole();
    public Role updateRole(Role role);
    public Role findRoleById(int id);
    public Role findRoleByLibelle(String libelle);
    public void deleteRole(int id);
}
