package org.springframework.terrabia.models.app;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.terrabia.models.enumerations.PaymentMethod;
import org.springframework.terrabia.models.enumerations.ProcessStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private ProcessStatus status;

    private String referenceTransaction;

    private LocalDateTime paymentDate;
}
