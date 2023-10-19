package com.example.agitana.dto;

import lombok.Data;
@Data
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private CategoriaDTO categoriaDTO;
    private TipoDTO tipoDTO;
}