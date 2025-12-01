package org.springframework.terrabia.models.app;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock")

public class Stock {

    @Id
@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long totalQuantity;

    @OneToMany(cascade = CascadeType.DETACH)
    private Set<StockByProduct> stockByProducts;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
