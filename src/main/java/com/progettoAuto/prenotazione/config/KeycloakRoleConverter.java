package com.progettoAuto.prenotazione.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // 1. Accediamo alla sezione "realm_access" del JSON del token
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        // Se non ci sono ruoli, restituiamo una lista vuota per evitare errori
        if (realmAccess == null || realmAccess.isEmpty()) {
            return new ArrayList<>();
        }

        // 2. Prendiamo la lista dei ruoli (es. "admin", "user")
        Collection<String> roles = (Collection<String>) realmAccess.get("roles");

        // 3. Li trasformiamo in Authority di Spring aggiungendo "ROLE_"
        // Esempio: "admin" diventa "ROLE_admin"
        return roles.stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}