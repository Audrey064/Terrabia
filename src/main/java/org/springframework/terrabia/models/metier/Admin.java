package org.springframework.terrabia.models.metier;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")

public class Admin extends User{
}
