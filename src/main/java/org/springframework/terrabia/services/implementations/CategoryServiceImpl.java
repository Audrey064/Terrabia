package org.springframework.terrabia.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.terrabia.exceptions.ResourceAlreadyExistsException;
import org.springframework.terrabia.exceptions.ResourceNotFoundException;
import org.springframework.terrabia.models.app.Category;
import org.springframework.terrabia.models.dtos.responses.CategoryDTO;
import org.springframework.terrabia.repositories.CategoryRepository;
import org.springframework.terrabia.services.interfaces.CategoryService;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.terrabia.utils.Utilities.verifyCreateCategory;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        verifyCreateCategory(categoryDTO);

        if(isTheNameAlreadyExists(categoryDTO)){
            throw new ResourceAlreadyExistsException("Category with name " + categoryDTO.getName() + " already exists");
        }

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .build();

        categoryRepository.save(category);

        return categoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO) {

        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }

        if(categoryDTO.getName() != null){
            category.setName(categoryDTO.getName());
        }

        if(categoryDTO.getDescription() != null){
            category.setDescription(categoryDTO.getDescription());
        }

        categoryRepository.save(category);

        return categoryDTO;
    }

    @Override
    public String deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }

        categoryRepository.delete(category);

        return "Category with id " + id + " has been deleted";
    }

    @Override
    public Set<CategoryDTO> getAllCategories() {

        List<Category> allCategories = categoryRepository.findAll();

        return allCategories
                .stream()
                .map(Category -> {
                    CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(Category.getName());
                categoryDTO.setDescription(Category.getDescription());
                return categoryDTO;
                }).collect(Collectors.toSet());
    }

    @Override
    public CategoryDTO getCategoryById(UUID id) {

        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }
        return mapTOCategoryDTO(category);
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {

        Category category = categoryRepository.findByName(name).orElse(null);

        if(category == null){
            throw new ResourceNotFoundException("Category with name " + name + " not found");
        }
        return mapTOCategoryDTO(category);
    }

    public boolean isTheNameAlreadyExists(CategoryDTO categoryDTO) {

        Category isExits = categoryRepository.findByName( categoryDTO.getName()).orElse(null);

        return isExits != null;
    }

    private CategoryDTO mapTOCategoryDTO(Category category){
        return CategoryDTO.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
