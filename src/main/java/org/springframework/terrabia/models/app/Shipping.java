package org.springframework.terrabia.models.app;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.terrabia.models.enumerations.CoverageArea;
import org.springframework.terrabia.models.enumerations.ProcessStatus;
import org.springframework.terrabia.models.metier.DeliveryAgency;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "shipping")

public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private float amount;

    @Enumerated(EnumType.STRING)
    private ProcessStatus status;

    private LocalDateTime shippingDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Order order;

    @ManyToOne(cascade = CascadeType.DETACH)
    private DeliveryAgency agency;

    @Enumerated(EnumType.STRING)
    private CoverageArea area;
}
