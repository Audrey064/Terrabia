package org.springframework.terrabia.models.app;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private float totalAmount;

    @CreationTimestamp
    private LocalDateTime orderDate;

}

