package org.springframework.terrabia.models.app;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.terrabia.models.enumerations.UNITY;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_by_product")

public class StockByProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private UNITY unity;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Product product;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
