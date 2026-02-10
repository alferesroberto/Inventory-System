package com.inventory.inventory_api.controller;

import com.inventory.inventory_api.security.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username,
            @RequestParam String password
    ) {

        if (!username.equals("admin") || !password.equals("admin123")) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(username);

        return Map.of("token", token);
    }
}
