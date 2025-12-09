package org.springframework.terrabia.services.interfaces;

import org.springframework.terrabia.models.dtos.responses.CategoryDTO;

import java.util.Set;
import java.util.UUID;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO);

    String deleteCategory(UUID id);

    Set<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(UUID id);

    CategoryDTO getCategoryByName(String name);
}
