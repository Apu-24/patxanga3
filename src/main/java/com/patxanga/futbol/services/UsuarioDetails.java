package com.patxanga.futbol.services;

import com.patxanga.futbol.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UsuarioDetails implements UserDetails {

    private final Usuario usuario;

    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí puedes asignar los roles o permisos de tu entidad Usuario.
        // Si el Usuario tiene un campo `rol`, podrías mapearlo a GrantedAuthority.
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));
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
        return true;  // Cambia esto si tienes lógica para cuentas expiradas.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Cambia esto si tienes lógica para cuentas bloqueadas.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Cambia esto si tienes lógica para credenciales expiradas.
    }

    @Override
    public boolean isEnabled() {
        return true;  // Cambia esto si tienes lógica para usuarios deshabilitados.
    }
}
