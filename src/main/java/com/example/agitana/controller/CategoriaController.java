package com.example.agitana.controller;

import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "/Admin/Categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/listar")
    public List<CategoriaDTO> listarCategoria() {
        return categoriaService.listarCategoria();
    }

}
