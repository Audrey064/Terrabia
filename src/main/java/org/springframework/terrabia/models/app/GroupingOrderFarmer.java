package org.springframework.terrabia.models.app;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.terrabia.models.enumerations.ProcessStatus;
import org.springframework.terrabia.models.metier.Farmer;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "grouping_order_farmer")

public class GroupingOrderFarmer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProcessStatus status;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Farmer farmer;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Order order;
}
