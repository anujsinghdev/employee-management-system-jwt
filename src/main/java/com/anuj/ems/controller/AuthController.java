package com.anuj.ems.controller;

import com.anuj.ems.dto.AuthResponse;
import com.anuj.ems.dto.LoginRequest;
import com.anuj.ems.dto.RegisterRequest;
import com.anuj.ems.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}