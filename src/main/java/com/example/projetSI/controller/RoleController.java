package com.example.projetSI.controller;

import com.example.projetSI.model.Role;
import com.example.projetSI.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private final RoleService roleService;

    //constructeur
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // ================================= GET Mapping =================================

    @GetMapping("/getAll")
//    @PreAuthorize("hasAuthority('GET_ROLES')")
    public ResponseEntity<List<Role>> getAllRole(){
        List<Role> roles = roleService.getAllRole();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/getLibelle/{libelle}")
//    @PreAuthorize("hasAuthority('GET_ROLES')")
    public ResponseEntity<Role> getRoleById(@PathVariable("libelle") String libelle){
        Role role = roleService.findRoleByLibelle(libelle);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
//    @PreAuthorize("hasAuthority('GET_ROLES')")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") int id){
        Role role = roleService.findRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    // ================================= POST Maping =================================

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        Role newRole = roleService.saveRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    // ================================= PUT Mapping =================================

    @PutMapping("/update")
//    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        Role updatedRole = roleService.updateRole(role);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    // ================================= DELETE Mapping =================================
    @Transactional
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public ResponseEntity<?> deleteRole(@PathVariable("id") int id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
