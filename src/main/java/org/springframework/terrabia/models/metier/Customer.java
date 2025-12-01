package org.springframework.terrabia.models.metier;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "client")

public class Customer extends Person {

}
