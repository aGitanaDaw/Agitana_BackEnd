package com.example.agitana.dto;

import com.example.agitana.enums.TipoSolicitud;
import lombok.Data;

@Data
public class SolicitudesDTO {
    private Integer id;
    private AlmacenDTO almacenDTO;
    private PersonaDTO personaDTO;
    private CategoriaDTO categoriaDTO;
    private TipoSolicitud estado;
}
