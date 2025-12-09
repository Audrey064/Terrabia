package org.springframework.terrabia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.terrabia.models.app.Category;

import java.util.List;


import java.util.Optional;
import java.util.UUID;


@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findAll();

    Optional<Category> findByName(String name);

    Optional<Category> findById(UUID id);

}
