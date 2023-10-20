package com.example.agitana.controller;

import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.PersonaService;
import com.example.agitana.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController()
@RequestMapping(path = "/Tipo")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


}
