package com.example.agitana.controller;
import com.example.agitana.models.Solicitudes;
import com.example.agitana.service.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController()
@RequestMapping(path = "/Admin/Solicitudes")
public class SolicitudesController {
    //crear, eliminar y listar
    private final SolicitudesService solicitudesService;

    @Autowired
    public SolicitudesController(SolicitudesService solicitudesService) {
        this.solicitudesService = solicitudesService;
    }

    // @GetMapping(value = "/listar")
    // public List<Solicitudes> listarSolicitudes() {
    // return solicitudesService.listarSolicitudes();
    // }
}
