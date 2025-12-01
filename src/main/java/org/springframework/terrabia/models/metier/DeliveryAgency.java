package org.springframework.terrabia.models.metier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery_agency")

public class DeliveryAgency extends User{

    private String agencyName;

    private String address;

}
