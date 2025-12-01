package org.springframework.terrabia.models.enumerations;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum UserRole {
    ADMIN,
    CUSTOMER,
    DELIVERY_AGENCY,
    FARMER;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
