package com.example.agitana.dto;

import lombok.Data;
@Data
public class DonacionDTO {
    private Integer id;
    private Integer cantidad;
    private Integer id_tipo;
    private String  descripcion_producto;
    private Integer id_persona;
    private String estado;
}