package com.example.agitana.controller;



import com.example.agitana.models.productos;

import com.example.agitana.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/listar")
    public List<productos> listarProductos() {
        return productoService.listarProductos();
    }
}
