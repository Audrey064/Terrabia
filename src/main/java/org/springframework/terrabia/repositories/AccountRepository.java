package org.springframework.terrabia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.terrabia.models.app.Account;

import java.util.UUID;

@Repository

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
