package com.anuj.ems.service;

import com.anuj.ems.dto.AuthResponse;
import com.anuj.ems.dto.LoginRequest;
import com.anuj.ems.dto.RegisterRequest;
import com.anuj.ems.entity.User;
import com.anuj.ems.repository.UserRepository;
import com.anuj.ems.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        System.out.println("LOGIN USERNAME = " + request.getUsername());

        String token = jwtService.generateToken(request.getUsername());

        return new AuthResponse(token);


    }
}