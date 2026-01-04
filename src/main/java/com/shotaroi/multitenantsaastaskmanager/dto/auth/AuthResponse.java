package com.shotaroi.multitenantsaastaskmanager.dto.auth;

import java.util.UUID;

public record AuthResponse(UUID userId, String email, String accessToken) {}
