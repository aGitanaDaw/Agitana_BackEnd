package com.example.agitana.dto;

import com.example.agitana.enums.TipoPersona;
import lombok.Data;
@Data
public class PersonaDTO {
    private Integer id;
    private String nombre;
    private String apellido_Primero;
    private String apellido_Segundo;
    private String telefono;
    private String dni;
    private TipoPersona tipoPersona;
}