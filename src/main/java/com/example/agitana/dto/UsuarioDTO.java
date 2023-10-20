package com.example.agitana.dto;

import com.example.agitana.enums.TipoRol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String username;
    private String password;
    private PersonaDTO personaDTO;
    private TipoRol tipoRol;
}
