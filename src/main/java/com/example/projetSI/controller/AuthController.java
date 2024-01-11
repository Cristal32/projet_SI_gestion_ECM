package com.example.projetSI.controller;

import com.example.projetSI.payload.AuthenticationRequest;
import com.example.projetSI.payload.AuthenticationResponse;
import com.example.projetSI.repository.UtilisateurDao;
import com.example.projetSI.security.jwt.JwtService;
import com.example.projetSI.security.services.UserDetailsImpl;
import com.example.projetSI.service.UtilisateurService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger LOGGER = LogManager.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        LOGGER.error("authenticate controller: username = " + request.getUsername() + " pwd = " + request.getPassword()); //checked
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            LOGGER.error("auth success");
        } catch (AuthenticationException ex) {
            LOGGER.error("Authentication failed: " + ex.getMessage());
            throw ex; // Rethrow the exception to let it propagate and handle it appropriately
        }

        //if i get to this point, it means the user is successfully authenticated
        LOGGER.error("auth success");
        var user = utilisateurDao.findByUsername(request.getUsername()).orElseThrow();
        var userAccesses = utilisateurService.getUtilisateurAccesses(user);
        var userDetail = UserDetailsImpl.build(user);
        var jwtToken = jwtService.generateToken(userDetail);
        return ResponseEntity.ok(AuthenticationResponse.builder()
                .withToken(jwtToken)
                .withUserId(user.getId())
                .withUsername(request.getUsername())
                .withAuthorities(userAccesses)
                .build());
    }



}