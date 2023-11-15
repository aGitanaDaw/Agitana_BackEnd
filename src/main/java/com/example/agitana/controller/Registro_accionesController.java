package com.example.agitana.controller;

import com.example.agitana.dto.Registro_accionesDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.models.Registro_acciones;
import com.example.agitana.models.Solicitudes;
import com.example.agitana.service.Registro_accionesService;
import com.example.agitana.service.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Registro_accionesController {

   @Autowired
   private Registro_accionesService registro_accionesService;

    @GetMapping(value = "/listar")
    public List<Registro_accionesDTO> listarRegistro_acciones() {
        return registro_accionesService.listarRegistro_acciones();
    }

    @PostMapping(value = "/crear")
    public Registro_accionesDTO crearRegistro_acciones(@RequestBody Registro_accionesDTO dto){
        return registro_accionesService.crearRegistro_acciones(dto);
    }

    @PutMapping(value = "/modificar")
    public Registro_acciones modificarRegistro_acciones(@RequestBody Registro_accionesDTO registro_accionesDTO){
        return registro_accionesService.modificarRegistro_acciones(registro_accionesDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarRegistro_acciones(@RequestBody Registro_accionesDTO registroAccionesDTO){
        return registro_accionesService.eliminarRegistro_acciones(registroAccionesDTO);
    }
}
