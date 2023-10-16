package com.example.agitana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/stock")
public class StockController {
    @Autowired
    private final ProductoService productoService;

    @GetMapping(value = "/listar")
    public List<ProductoDTO> listarProductos(){
        return productoService.listarProductos();
    }
}
