package org.springframework.terrabia.services.implementations;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.terrabia.exceptions.BusinessValidation;
import org.springframework.terrabia.exceptions.ResourceAlreadyExistsException;
import org.springframework.terrabia.exceptions.ResourceNotFoundException;
import org.springframework.terrabia.models.app.Account;
import org.springframework.terrabia.models.dtos.requests.LoginRequest;
import org.springframework.terrabia.models.dtos.requests.RegisterRequest;
import org.springframework.terrabia.models.dtos.responses.RegisterResponse;
import org.springframework.terrabia.models.enumerations.UserRole;
import org.springframework.terrabia.models.metier.Customer;
import org.springframework.terrabia.models.metier.Farmer;
import org.springframework.terrabia.models.metier.User;
import org.springframework.terrabia.repositories.AccountRepository;
import org.springframework.terrabia.repositories.CustomerRepository;
import org.springframework.terrabia.repositories.FarmerRepository;
import org.springframework.terrabia.repositories.UserRepository;
import org.springframework.terrabia.services.interfaces.AuthenticationService;
import org.springframework.terrabia.services.interfaces.JwtService;

import java.util.UUID;

import static org.springframework.terrabia.utils.Utilities.verifyRegisterRequest;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final FarmerRepository farmerRepository;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authManager;
    private final CustomerRepository customerRepository;

    @Override
    public RegisterResponse signUp(RegisterRequest request) {

        verifyRegisterRequest(request);

/*        if(request.getRole() ==  UserRole.ADMIN ){
              throw new SecurityException("You can't sign up an administrative user");
            throw new BusinessException("An admin can't self-register");
        }

        if(request.getRole() ==  UserRole.DELIVERY_AGENCY ){
                throw new SecurityException("You can't sign up an agency");
            throw new BusinessException("An agency can't self-register");
        }*/

        if(isForbiddenSelfRegistrationRole(request.getRole())){
            throw new BusinessValidation("You can't self-register");
        }

        validateUniqueConstraints(request);

        User user = createUserByRole(request);

        setCommonProperties(user, request);

        user.setAccount(createAccount());

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user.getEmail());

        return RegisterResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();


/*        if(verifyRegisterRequest(request)){

            if(request.getRole() ==  UserRole.ADMIN ){
                throw new SecurityException("You can't sign up an administrative user");
                throw new BusinessException("An admin can't self-register");
            }

            if(request.getRole() ==  UserRole.DELIVERY_AGENCY ){
               throw new SecurityException("You can't sign up an agency");
                throw new BusinessException("An admin can't self-register");
            }

            validateUniqueConstraints(request);

            User user = createUserByRole(request);

            setCommonProperties(user, request);

            user.setAccount(createAccount());

            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user.getEmail());

            return RegisterResponse.builder()
                    .token(jwtToken)
                    .user(user)
                    .build();
        }

        throw new IllegalArgumentException("Missing required fields");
        throw new BusinessValidation("You should fill the fields correctly");*/
    }

    public RegisterResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.email()).orElse(null);

        if (user == null){
            throw new ResourceNotFoundException("There's no user with the email " + request.email());
        }

        String jwtToken = jwtService.generateToken(user.getEmail());

        return RegisterResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }

    public void validateUniqueConstraints(RegisterRequest request)  {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new ResourceAlreadyExistsException("Email already exists");
        }

        /*if(userRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()){
            throw new ResourceAlreadyExistsException("Phone number already exists");
        }*/

        if(request.getRole() == UserRole.FARMER || request.getRole() == UserRole.CUSTOMER ){
            if(farmerRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent() || customerRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()){
                throw new ResourceAlreadyExistsException("Phone number already exists");
            }
        }

        if(request.getRole()== UserRole.FARMER && farmerRepository.findByDomainName(request.getDomainName()).isPresent()){
            throw new ResourceAlreadyExistsException("Email already exists");
        }
    }

    public void setCommonProperties(User user, RegisterRequest request) {
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
    }

    public User createUserByRole(RegisterRequest request) {

        return switch (request.getRole()){

            case CUSTOMER -> {

                Customer customer = new Customer();
                customer.setFirstName(request.getFirstName());
                customer.setLastName(request.getLastName());
                customer.setPhoneNumber(request.getPhoneNumber());
                customer.setAddress(request.getAddress());
                customer.setRole(UserRole.CUSTOMER);

                yield customer;
            }

            case FARMER ->  {
                Farmer farmer = new Farmer();

                farmer.setFirstName(request.getFirstName());
                farmer.setLastName(request.getLastName());
                farmer.setPhoneNumber(request.getPhoneNumber());
                farmer.setAddress(request.getAddress());
                farmer.setDomainName(request.getDomainName());
                farmer.setRole(UserRole.FARMER);

                yield farmer;
            }

            default -> throw new IllegalStateException("Unexpected value: " + request.getRole());
        };
    }

    public Account createAccount() {
        Account account = Account.builder()
                .accountNumber(UUID.randomUUID())
                .balance(0)
                .build();


        return accountRepository.save(account);
    }

    private boolean isForbiddenSelfRegistrationRole(UserRole role) {
        return role == UserRole.ADMIN || role == UserRole.DELIVERY_AGENCY;
    }

}
