package org.springframework.terrabia.services.interfaces;

import org.springframework.terrabia.models.dtos.requests.LoginRequest;
import org.springframework.terrabia.models.dtos.requests.RegisterRequest;
import org.springframework.terrabia.models.dtos.responses.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse signUp(RegisterRequest request);

    RegisterResponse login(LoginRequest request);

}
