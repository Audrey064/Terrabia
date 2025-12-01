package org.springframework.terrabia.models.app;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="product")

public class Product {
    @Id
@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private float price;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
