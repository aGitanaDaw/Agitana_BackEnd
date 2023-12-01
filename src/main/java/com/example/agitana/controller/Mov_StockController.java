package com.example.agitana.controller;

import com.example.agitana.dto.Mov_StockDTO;
import com.example.agitana.service.Mov_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/Admin/Mov_Stock")
@CrossOrigin(origins = "http://localhost:4200")
public class Mov_StockController {
    @Autowired
    private final Mov_StockService mov_stockService;

    public Mov_StockController(Mov_StockService stockService) {
        this.mov_stockService = stockService;
    }
    @GetMapping(value = "/listar")
    public List<Mov_StockDTO> listarMovimientos() {
        return mov_stockService.listarMovimientos();
    }

    @PostMapping(value = "/crear")
    public Mov_StockDTO createStock(@RequestBody Mov_StockDTO dto){

        return mov_stockService.createMovimiento(dto);
    }

}
