package org.springframework.terrabia.models.metier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.terrabia.models.app.Stock;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Farmer")

public class Farmer extends Person {

    @Column(nullable = false,  unique = true)
    private String domainName;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Stock stock;
}
