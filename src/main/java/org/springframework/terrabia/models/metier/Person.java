package org.springframework.terrabia.models.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "person")

public class Person extends User{

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;
}
