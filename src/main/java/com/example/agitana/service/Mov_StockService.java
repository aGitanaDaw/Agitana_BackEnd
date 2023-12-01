package com.example.agitana.service;


import com.example.agitana.Repository.Mov_StockRepository;
import com.example.agitana.Repository.ProductoRepository;
import com.example.agitana.converter.Mov_StockMapper;
import com.example.agitana.dto.Mov_StockDTO;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.models.Mov_Stock;
import com.example.agitana.models.Producto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class Mov_StockService {
    @Autowired
    private final Mov_StockRepository mov_stockRepository;
    @Autowired
    private Mov_StockMapper mov_stockMapper;

    @Autowired
    public Mov_StockService(Mov_StockRepository mov_stockRepository) {
        this.mov_stockRepository = mov_stockRepository;
    }
    public Mov_Stock getById(Integer id){
        return mov_stockRepository.findById(id).orElse(null);
    }
    public List<Mov_StockDTO> listarMovimientos() {
        return mov_stockMapper.toDTO(mov_stockRepository.findAll());
    }
    public Mov_StockDTO createMovimiento(Mov_StockDTO mov_StockDTO){
        return mov_stockMapper.toDTO(mov_stockRepository.save(mov_stockMapper.toEntity(mov_StockDTO)));
    }
}
