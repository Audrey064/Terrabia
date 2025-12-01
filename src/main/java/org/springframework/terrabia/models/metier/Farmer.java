package org.springframework.terrabia.models.metier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

public class Farmer extends User {

    private String domainName;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Stock stock;
}
