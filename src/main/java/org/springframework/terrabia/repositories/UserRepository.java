package org.springframework.terrabia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.terrabia.models.metier.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

  //  Optional<User> findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
}
