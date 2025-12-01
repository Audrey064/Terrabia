package org.springframework.terrabia.models.app;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "order_line")

public class OrderLIne {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private int quantity;

    private float unitPrice;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Order order;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Product product;
}
