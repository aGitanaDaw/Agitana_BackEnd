package com.example.agitana.dto;

import com.example.agitana.enums.TipoPersona;
import lombok.Data;
@Data
public class personaDTO {
    private Integer id;
    private String nombre;
    private String apellido_primero;
    private String apellido_segundo;
    private String telefono;
    private String dni;
    private TipoPersona tipopersona;
}