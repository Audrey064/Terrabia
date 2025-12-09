package org.springframework.terrabia.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.terrabia.models.dtos.requests.LoginRequest;
import org.springframework.terrabia.models.dtos.requests.RegisterRequest;
import org.springframework.terrabia.models.dtos.responses.RegisterResponse;
import org.springframework.terrabia.services.interfaces.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")

@RequiredArgsConstructor

public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<RegisterResponse> signUp(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = authenticationService.signUp(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<RegisterResponse> login(@RequestBody LoginRequest request) {
        RegisterResponse response = authenticationService.login(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
