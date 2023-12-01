package com.example.agitana.dto;

import lombok.Data;

@Data
public class Mov_StockDTO {
    private Integer id;
    private SolicitudesDTO solicitudesDTO;
    private DonacionDTO donacionDTO;
    private StockDTO stockDTO;
    private Integer cantidad;
}
