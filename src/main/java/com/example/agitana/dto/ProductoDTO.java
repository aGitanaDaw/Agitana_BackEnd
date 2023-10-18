package com.example.agitana.dto;

import lombok.Data;
import lombok.NonNull;
@Data
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private CategoriaDTO categoriaDTO;
    private TipoDTO tipoDTO;
}