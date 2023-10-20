package com.example.agitana.security.service;

import com.example.agitana.models.Usuario;

public interface IJwtService {
    String extractUserName(String token);

    String generateToken(Usuario usuario);

    boolean isTokenValid(String token, Usuario usuario);
}
