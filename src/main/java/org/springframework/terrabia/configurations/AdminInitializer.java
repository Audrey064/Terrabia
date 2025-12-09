package org.springframework.terrabia.configurations;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.terrabia.models.app.Account;
import org.springframework.terrabia.models.enumerations.UserRole;
import org.springframework.terrabia.models.metier.Admin;
import org.springframework.terrabia.models.metier.User;
import org.springframework.terrabia.repositories.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor

public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminIfNotExist() {
        if(userRepository.findByRole(UserRole.ADMIN).isEmpty()){

            Account adminAccount = Account.builder()
                    .accountNumber(UUID.randomUUID())
                    .balance(0)
                    .build();

            User admin = new Admin();
            admin.setEmail("admin@terrabia.com");
            admin.setPasswordHash(passwordEncoder.encode("MustChange123"));
            admin.setRole(UserRole.ADMIN);
            admin.setAccount(adminAccount);

            userRepository.save(admin);
        }
    }
}
