package com.example.agitana.service;

import com.example.agitana.Repository.StockRepository;
import com.example.agitana.converter.StockMapper;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.StockDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Stock;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
public class StockService {
    @Autowired
    private final StockRepository stockrepository;
    @Autowired
    private StockMapper stockMapper;

    public StockService(StockRepository Stockrepository, StockRepository stockrepository) {
        this.stockrepository = stockrepository;
    }
    public List<StockDTO> listarStock() {
        return stockMapper.toDTO(stockrepository.findAll());
    }
    public Stock getById(Integer id){
        return stockrepository.findById(id).orElse(null);
    }
    public StockDTO createStock(StockDTO stockDTO){
        return stockMapper.toDTO(stockrepository.save(stockMapper.toEntity(stockDTO)));
    }
    public Stock modificarStock(StockDTO stockDTO){
        Stock stock = stockrepository.findById(stockDTO.getId()).orElse(null);

        if(stock == null){
            return null;
        }else{
            stock.setCantidad(stockDTO.getCantidad());
            Stock stockModificado = stockrepository.save(stock);
            return stockModificado;
        }

    }
    public String eliminarStock(StockDTO stockDTO){
        Stock stockEliminar = stockrepository.findById(stockDTO.getId()).orElse(null);
        if(stockEliminar != null){
            stockrepository.delete(stockEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }


}
