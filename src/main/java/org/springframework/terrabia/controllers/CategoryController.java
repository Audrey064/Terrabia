package org.springframework.terrabia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.terrabia.models.dtos.responses.CategoryDTO;
import org.springframework.terrabia.services.interfaces.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(name = "api/v1/category")

@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-a-category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {

        CategoryDTO newCategory = categoryService.addCategory(categoryDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newCategory);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-category/id={id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO) {

        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedCategory);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-category/id={id}")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID id) {

        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'FARMER', 'CUSTOMER')")
    @GetMapping("/get/all-categories")
    public ResponseEntity<Set<CategoryDTO>> getAllCategories() {

        Set<CategoryDTO> categoryDTOs = categoryService.getAllCategories();

        if(categoryDTOs.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(categoryDTOs);
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'FARMER', 'CUSTOMER')")
    @GetMapping("/get/category-by-id/id={id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable UUID id) {

        CategoryDTO categoryDTO = categoryService.getCategoryById(id);

        if(categoryDTO == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoryDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'FARMER', 'CUSTOMER')")
    @GetMapping("/get/category-by-name/name={name}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable String name) {

        CategoryDTO categoryDTO = categoryService.getCategoryByName(name);

        if(categoryDTO == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoryDTO);
    }
}
