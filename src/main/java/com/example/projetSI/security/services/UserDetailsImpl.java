package com.example.projetSI.security.services;

import com.example.projetSI.model.Access;
import com.example.projetSI.model.Role;
import com.example.projetSI.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private int id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    //constructeur
    public UserDetailsImpl(int id, String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    //methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		/*Set<Access> ListeUserAccesses = new HashSet<>();
		Set<Role> listeRoles = this.roles;
		for(Role role : listeRoles) {
			Set<Access> listeRoleAccesses = role.getRoleAccesses();
			ListeUserAccesses.addAll(listeRoleAccesses);
		}
		return ListeUserAccesses;*/
        return authorities;
    }

    //build an instance of UserDetailsImpl from an instance of Utilisateur
    public static UserDetailsImpl build(Utilisateur user) {
        Role userRole = user.getRole();
        Collection<? extends GrantedAuthority> authorities = userRole.getAccesses().stream()
                .map(access -> new SimpleGrantedAuthority(access.getAuthority()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities);
    }

    public int getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}