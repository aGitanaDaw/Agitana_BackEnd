package com.example.agitana.controller;



import com.example.agitana.Repository.DonacionRepository;
import com.example.agitana.models.Donacion;

import com.example.agitana.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/Admin/Donacion")
public class DonacionController {

    @Autowired
    DonacionRepository donacionRepository;
    public final DonacionService donacionService;

    @Autowired
    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping(value = "/listar")
    public List<Donacion> listarDonacion() {
        return donacionService.listarDonacion();
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Donacion> crearDonacion(Donacion donacion) {
       try {
        Donacion _donacion = donacionRepository.save(new Donacion(donacion.getId(),donacion.getCantidad(), donacion.getDescripcion_producto(),
                    donacion.getId_tipo(), donacion.getId_persona(), donacion.getEstado()));
            return new ResponseEntity<>(_donacion, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

  }

    @DeleteMapping("/donacion/{id}")
    public ResponseEntity<HttpStatus> eliminarDonacion(@PathVariable("id") long id) {
        try {
            donacionRepository.deleteById((int) id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
