package com.example.agitana.dto;

import com.example.agitana.enums.TipoSolicitud;
import lombok.Data;
@Data
public class DonacionDTO {
    private Integer id;
    private CategoriaDTO categoriaDTO;
    private String  descripcion_producto;
    private PersonaDTO personaDTO;
    private TipoSolicitud estado;
}