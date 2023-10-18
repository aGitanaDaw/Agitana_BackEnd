package com.example.agitana.controller;

import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.service.AlmacenService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AlmacenController {
    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping(value = "/listar")
    public List<AlmacenDTO> listarAlmacen() {
        return almacenService.listarAlmacen();
    }
}
