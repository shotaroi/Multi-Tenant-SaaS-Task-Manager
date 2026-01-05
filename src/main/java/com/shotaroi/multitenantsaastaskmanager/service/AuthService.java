package com.shotaroi.multitenantsaastaskmanager.service;

import com.shotaroi.multitenantsaastaskmanager.domain.User;
import com.shotaroi.multitenantsaastaskmanager.dto.auth.AuthResponse;
import com.shotaroi.multitenantsaastaskmanager.dto.auth.LoginRequest;
import com.shotaroi.multitenantsaastaskmanager.dto.auth.RegisterRequest;
import com.shotaroi.multitenantsaastaskmanager.repository.UserRepository;
import com.shotaroi.multitenantsaastaskmanager.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shotaroi.multitenantsaastaskmanager.security.JwtService;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public AuthResponse register(RegisterRequest req) {
        String email = req.email().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User(
                UUID.randomUUID(),
                email,
                passwordEncoder.encode(req.password()),
                Instant.now()
        );

        userRepository.save(user);
        String token = jwtService.createAccessToken(user.getId(), user.getEmail());
        return new AuthResponse(user.getId(), user.getEmail(), token);

    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest req) {
        String email = req.email().trim().toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(req.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtService.createAccessToken(user.getId(), user.getEmail());
        return new AuthResponse(user.getId(), user.getEmail(), token);

    }
}
