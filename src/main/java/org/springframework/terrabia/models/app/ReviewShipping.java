package org.springframework.terrabia.models.app;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.terrabia.models.enumerations.Rating;
import org.springframework.terrabia.models.metier.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reviewShipping")

public class ReviewShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String comment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Shipping shipping;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
