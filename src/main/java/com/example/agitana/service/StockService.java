package com.example.agitana.service;

import com.example.agitana.Repository.ProductoRepository;
import com.example.agitana.Repository.SolicitudesRepository;
import com.example.agitana.Repository.StockRepository;
import com.example.agitana.converter.ProductoMapper;
import com.example.agitana.converter.StockMapper;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.dto.StockDTO;
import com.example.agitana.models.Producto;
import com.example.agitana.models.Stock;

import java.util.List;

public class StockService {
    private final StockRepository Stockrepository;

    public StockService(StockRepository Stockrepository) {
        this.Stockrepository = Stockrepository;
    }
    public List<Stock> listarProductos() {

        return Stockrepository.findAll();
    }

}
