package com.example.agitana.dto;

import com.example.agitana.enums.TipoRol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String contrasenya;
    private Integer id_almacen_usuario;
    private TipoRol tipoRol;
}
