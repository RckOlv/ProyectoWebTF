package com.proyectoweb.repuestos.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.proyectoweb.repuestos.entity.Usuario;

public class CustomUserDetails implements UserDetails {
    
    private final Usuario usuario;

    public CustomUserDetails(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles().stream()
                .map(rol -> (GrantedAuthority) () -> "ROLE_" + rol.getNombre().toUpperCase())
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Podés hacer lógica con el campo estado si querés
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
        // Agregar log para ver el valor de estado
        System.out.println("Estado del usuario: " + usuario.getEstado());
        
        return usuario.getEstado().toString().equals("ACTIVO");
    }
}
