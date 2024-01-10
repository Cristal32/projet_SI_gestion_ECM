package com.example.projetSI.service.implementation;

import com.example.projetSI.model.Access;
import com.example.projetSI.model.Role;
import com.example.projetSI.model.Utilisateur;
import com.example.projetSI.repository.UtilisateurDao;
import com.example.projetSI.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur findUtilisateurById(int id) {
        return utilisateurDao.findById(id).orElse(null);
    }

    @Override
    public Set<Access> getUtilisateurAccesses(Utilisateur user) {
        Role userRole = user.getRole();
        Set<Access> userAccesses = new HashSet<>();
        userAccesses.addAll(userRole.getAccesses());
        return userAccesses;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur user) {
        if(user.getPassword() != null) {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
        }
        return utilisateurDao.save(user);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
        if(user.getPassword() != null) {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
        }
        return utilisateurDao.save(user);
    }

    @Override
    public void deleteUtilisateur(int id) {
        // Implémentez la logique pour supprimer un utilisateur
        utilisateurDao.deleteById(id);
    }

    @Override
    public Utilisateur authentifierUtilisateur(String username, String password) {
        Utilisateur utilisateur = utilisateurDao.findByUsername(username).orElse(null);
        if (utilisateur != null && passwordEncoder.matches(password, utilisateur.getPassword())) {
            // Password matches, return the user
            return utilisateur;
        }
        return null;
    }
}
