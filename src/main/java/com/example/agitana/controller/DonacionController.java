package com.example.agitana.controller;



import com.example.agitana.Repository.DonacionRepository;
import com.example.agitana.dto.DonacionDTO;
import com.example.agitana.models.Donacion;

import com.example.agitana.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = {"/Admin/Donaciones","/User/Donaciones"})
@CrossOrigin(origins = "http://localhost:4200")
public class DonacionController {

    @Autowired
    DonacionRepository donacionRepository;
    public final DonacionService donacionService;

    @Autowired
    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping(value = "/listar")
    public List<DonacionDTO> listarDonacion() {
        return donacionService.listarDonacion();
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<DonacionDTO> listarSolicitudesPorId(@PathVariable Integer id) {
        DonacionDTO donacionesDTO = donacionService.listarDonacionPorId(id);

        if (donacionesDTO != null) {
            return ResponseEntity.ok(donacionesDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/crear")
    public DonacionDTO crearDonacion(@RequestBody DonacionDTO dto){
        return donacionService.crearDonacion(dto);
    }

    @PutMapping(value = "/modificar")
    public Donacion modificarDonacion(@RequestBody DonacionDTO donacionDTO){
        return donacionService.modificarDonacion(donacionDTO);
    }

    @DeleteMapping(value = "/eliminar")
    public String eliminarDonacion(@RequestBody DonacionDTO donacionDTO){
        return donacionService.eliminarDonacion(donacionDTO);
    }

}
