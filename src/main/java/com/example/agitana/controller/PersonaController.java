package com.example.agitana.controller;

import com.example.agitana.dto.*;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Persona;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.PersonaService;
import com.example.agitana.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/persona")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping(value = "/listar")
    public List<PersonaDTO> listarPersona() {
        return personaService.listarPersona();
    }
    @PostMapping(value = "/crear")
    public PersonaDTO crearPersona(@RequestBody PersonaDTO dto){
        return personaService.crearPersona(dto);
    }
    @PutMapping(value = "/modificar")
    public Persona modificarPersona(@RequestBody PersonaDTO personaDTO){
        return personaService.modificarPersona(personaDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarPersona(@RequestBody PersonaDTO personaDTO){
        return personaService.eliminarPersona(personaDTO);
    }


}
