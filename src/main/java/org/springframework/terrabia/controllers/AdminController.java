package org.springframework.terrabia.controllers;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.terrabia.models.dtos.responses.UserResponse;
import org.springframework.terrabia.models.enumerations.UserRole;
import org.springframework.terrabia.services.interfaces.AdminService;

import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(name = "api/v1/admin")

@RequiredArgsConstructor

public class AdminController {

    private final AdminService adminService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-users-by-role/role={role}")
    public ResponseEntity<Set<UserResponse>> getAllUsersByRole(@PathVariable UserRole role) {

        Set<UserResponse> responses = adminService.getAllUsersByRole(role);

        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(responses);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-user-by-id/id={id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {

        UserResponse user = adminService.getUserById(id);

        return ResponseEntity.ok(user);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-user-by-id/id={id}")
    public ResponseEntity<String > deleteUserById(@PathVariable UUID id) {

        String result = adminService.deleteUser(id);

        return ResponseEntity.ok(result);
    }


}
