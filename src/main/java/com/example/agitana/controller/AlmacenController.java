package com.example.agitana.controller;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.service.AlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping(path = "/almacen")
@CrossOrigin(origins = "http://localhost:4200")
public class AlmacenController {
    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping(value = "/listar")
    public List<AlmacenDTO> listarAlmacen() {
        return almacenService.listarAlmacen();
    }
    @PostMapping(value = "/crear")
    public AlmacenDTO createAlmacen(@RequestBody AlmacenDTO dto){

        return almacenService.createAlmacen(dto);
    }
    @PutMapping(value = "/modificar")
    public Almacen modificarAlmacen(@RequestBody AlmacenDTO almacenDTO){
        return almacenService.modificarAlmacen(almacenDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarAlmacen(@RequestBody AlmacenDTO almacenDTO){
        return almacenService.eliminarAlmacen(almacenDTO);
    }
}
