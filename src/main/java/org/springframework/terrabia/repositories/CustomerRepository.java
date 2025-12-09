package org.springframework.terrabia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.terrabia.models.metier.Customer;
import org.springframework.terrabia.models.metier.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
