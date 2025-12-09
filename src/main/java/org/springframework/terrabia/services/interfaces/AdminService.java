package org.springframework.terrabia.services.interfaces;



import org.springframework.terrabia.models.dtos.responses.UserResponse;
import org.springframework.terrabia.models.enumerations.UserRole;


import java.util.Set;
import java.util.UUID;

public interface AdminService {


    Set<UserResponse> getAllUsersByRole(UserRole role);

    UserResponse getUserById(UUID id);


    UserResponse getUserByEmail(String email);

    String deleteUser(UUID id);


}
