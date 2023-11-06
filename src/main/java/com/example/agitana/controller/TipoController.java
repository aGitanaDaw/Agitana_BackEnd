package com.example.agitana.controller;

import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController()
@RequestMapping(path = "/Admin/Tipo")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoController {
    private final TipoService tipoService;

    @Autowired
    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping(value = "/listar")
    public List<TipoDTO> listarTipo() {
        return tipoService.listarTipo();
    }
}
