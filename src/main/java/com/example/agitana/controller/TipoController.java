package com.example.agitana.controller;


import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Tipo;
import com.example.agitana.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/crear")
    public TipoDTO createTipo(@RequestBody TipoDTO dto){

        return tipoService.createTipo(dto);
    }
    @PutMapping(value = "/modificar")
    public Tipo tipoUsuario(@RequestBody TipoDTO tipoDTO){
        return tipoService.modificarTipo(tipoDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarTipo(@RequestBody TipoDTO tipoDTO){
        return tipoService.eliminarTipo(tipoDTO);
    }
}
