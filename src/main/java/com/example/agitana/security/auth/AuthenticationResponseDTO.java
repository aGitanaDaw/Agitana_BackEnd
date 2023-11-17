package com.example.agitana.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponseDTO {

    private String token;
    private String message;
    private String rol;
    private String tipo;
    private Integer id;
    private Integer idPersona;
}
