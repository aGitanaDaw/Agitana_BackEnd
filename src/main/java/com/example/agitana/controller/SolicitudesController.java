package com.example.agitana.controller;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Solicitudes;
import com.example.agitana.service.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = {"Admin/Solicitudes", "User/Solicitudes"})
public class SolicitudesController {


    private final SolicitudesService solicitudesService;

    @Autowired
    public SolicitudesController(SolicitudesService solicitudesService) {
        this.solicitudesService = solicitudesService;
    }

    @GetMapping(value = "/listar")
    public List<SolicitudesDTO> listarSolicitudes() {
        return solicitudesService.listarSolicitudes();
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<SolicitudesDTO> listarSolicitudesPorId(@PathVariable Integer id) {
        SolicitudesDTO solicitudesDTO = solicitudesService.listarSolicitudPorId(id);

        if (solicitudesDTO != null) {
            return ResponseEntity.ok(solicitudesDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/crear")
    public SolicitudesDTO createSolicitud(@RequestBody SolicitudesDTO dto){
        return solicitudesService.createSolicitudes(dto);
    }

    @PutMapping(value = "/modificar")
    public Solicitudes modificarSolicitud(@RequestBody SolicitudesDTO solicitudesDTO){
        return solicitudesService.modificarSolicitudes(solicitudesDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarSolicitudes(@RequestBody SolicitudesDTO solicitudesDTO){
        return solicitudesService.eliminarSolicitud(solicitudesDTO);
    }

}
