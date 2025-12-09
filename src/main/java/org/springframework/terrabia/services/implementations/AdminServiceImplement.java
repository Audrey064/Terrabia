package org.springframework.terrabia.services.implementations;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.terrabia.exceptions.ResourceNotFoundException;
import org.springframework.terrabia.models.dtos.responses.UserResponse;
import org.springframework.terrabia.models.enumerations.UserRole;
import org.springframework.terrabia.models.metier.User;
import org.springframework.terrabia.repositories.UserRepository;
import org.springframework.terrabia.services.interfaces.AdminService;


import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor

public class AdminServiceImplement implements AdminService {

    private final UserRepository userRepository;

    @Override
    public Set<UserResponse> getAllUsersByRole(UserRole role) {

        return userRepository.findAllByRole(role)
                .stream()
                .map(user -> {
                    UserResponse response = new UserResponse();
                response.setId(user.getId());
                response.setEmail(user.getEmail());
                response.setRole(user.getRole());
                return response;
                })
                .collect(Collectors.toSet());


    }

    @Override
    public UserResponse getUserById(UUID id) {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return mapToUserResponse(user);
    }

    @Override
    public UserResponse getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return mapToUserResponse(user);
    }

    @Override
    public String deleteUser(UUID id) {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.delete(user);

        return "User has been deleted";
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
