package com.example.agitana.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlmacenDTO {
    private Integer id;
    private String nombre;
    private Date fecha_entrada;

}
