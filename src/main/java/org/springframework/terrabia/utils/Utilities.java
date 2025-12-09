package org.springframework.terrabia.utils;

import org.springframework.terrabia.models.dtos.requests.RegisterRequest;
import org.springframework.terrabia.models.enumerations.UserRole;

public class Utilities {

    public static void verifyRegisterRequest(RegisterRequest request){

        if(request == null){
            throw new IllegalArgumentException("Request can't be null");
        }

        if (request.getEmail() == null
                || request.getPassword() == null
                || request.getFirstName() == null
                || request.getLastName() == null
                || request.getAddress() == null
                || request.getPhoneNumber() == null
                || request.getRole() == null
        ){
            throw new IllegalArgumentException("Missing required fields");
        }

        if(request.getRole() == UserRole.FARMER && request.getDomainName() == null){
            throw new IllegalArgumentException("Domain name is required for farmers");
        }

    }

}
