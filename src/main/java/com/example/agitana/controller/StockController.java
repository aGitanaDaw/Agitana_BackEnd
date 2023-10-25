package com.example.agitana.controller;

import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.StockDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Stock;
import com.example.agitana.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/Admin/Stock")
public class StockController {
    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping(value = "/listar")
    public List<StockDTO> listarStock() {
        return stockService.listarStock();
    }
    @PostMapping(value = "/crear")
    public StockDTO createStock(@RequestBody StockDTO dto){

        return stockService.createStock(dto);
    }
    @PutMapping(value = "/modificar")
    public Stock modificarStock(@RequestBody StockDTO stockDTO){
        return stockService.modificarStock(stockDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarStock(@RequestBody StockDTO stockDTO){
        return stockService.eliminarStock(stockDTO);
    }
}
