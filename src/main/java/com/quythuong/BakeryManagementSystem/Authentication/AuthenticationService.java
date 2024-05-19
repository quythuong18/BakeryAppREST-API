package com.quythuong.BakeryManagementSystem.Authentication;

import com.quythuong.BakeryManagementSystem.AppUser.AppUser;
import com.quythuong.BakeryManagementSystem.AppUser.AppUserRepository;
import com.quythuong.BakeryManagementSystem.JwtAuthentication.JwtService;
import com.quythuong.BakeryManagementSystem.utils.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse registerAsACustomer(AppUser request) {
        AppUser user = new AppUser();
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setPhone(request.getPhone());
        if(!request.getEmail().isEmpty()) { // email is optional
            user.setEmail(request.getEmail());
        }
        user.setRole(Role.ROLE_CUSTOMER);

        // save new user to DB
        user = appUserRepository.save(user);

        // generate JWT token for that account
        System.out.println("generate JWT token for that account");
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    // this for login request
    public AuthenticationResponse authenticate(AppUser request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        AppUser user = appUserRepository.findByUsername(request.getUsername()).orElseThrow();

        System.out.println(user.toString());
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
