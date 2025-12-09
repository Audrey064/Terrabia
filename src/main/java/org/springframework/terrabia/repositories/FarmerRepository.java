package org.springframework.terrabia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.terrabia.models.metier.Farmer;
import org.springframework.terrabia.models.metier.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, UUID> {

    Optional<Farmer> findByDomainName(String domainName);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
