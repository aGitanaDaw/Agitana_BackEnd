package com.example.agitana.controller;



import com.example.agitana.models.Donacion;

import com.example.agitana.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/donacion")
public class DonacionController {

    public final DonacionService donacionService;

    @Autowired
    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping(value = "/listar")
    public List<Donacion> listarDonacion() {
        return donacionService.listarDonacion();
    }

    //@PostMapping(value = "/crear")
    //public ResponseEntity<Donacion> crearDonacion(Donacion donacion) {
        //try {
           // Donacion _donacion = DonacionRepository.save(new Donacion(donacion.getCantidad(), donacion.getDescripcion_producto(),
             //       donacion.getId_tipo(), donacion.getId_persona(), donacion.getEstado()));
          //  return new ResponseEntity<>(_donacion, HttpStatus.CREATED);
       // } catch (Exception e) {
        //    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      //  }

  //  }

    @DeleteMapping("/donacion/{id_donacion}")
    public ResponseEntity<HttpStatus> eliminarDonacion(@PathVariable("id_donacion") long donacion_id) {
        ResponseEntity<HttpStatus> result;
        try {
            //donacionRepository.deleteById(id_donacion);
            result = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

}
