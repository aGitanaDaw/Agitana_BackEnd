package com.example.agitana.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Registro_accionesDTO {
    private Integer id;
    private Date fecha;
    private DonacionDTO donacionDTO;
    private SolicitudesDTO solicitudesDTO;


}