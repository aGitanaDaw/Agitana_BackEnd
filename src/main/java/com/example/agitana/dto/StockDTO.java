package com.example.agitana.dto;

import lombok.Data;

@Data
public class StockDTO {
    private Integer id;
    private Integer cantidad;
    private Integer id_producto;
    private Integer id_almacen;
}