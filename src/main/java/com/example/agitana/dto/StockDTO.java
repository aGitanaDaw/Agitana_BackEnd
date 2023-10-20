package com.example.agitana.dto;

import com.example.agitana.models.Almacen;
import lombok.Data;

@Data
public class StockDTO {
    private Integer id;
    private Integer cantidad;
    private ProductoDTO productoDTO;
    private AlmacenDTO almacenDTO;
}
