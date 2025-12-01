package org.springframework.terrabia.models.metier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.terrabia.models.app.Account;
import org.springframework.terrabia.models.enumerations.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    private String email;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Account account;
}
