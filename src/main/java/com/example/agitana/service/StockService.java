package com.example.agitana.service;

import com.example.agitana.Repository.AlmacenRepository;
import com.example.agitana.Repository.CategoriaRepository;
import com.example.agitana.Repository.ProductoRepository;
import com.example.agitana.Repository.StockRepository;
import com.example.agitana.converter.StockMapper;
import com.example.agitana.dto.StockDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Categoria;
import com.example.agitana.models.Producto;
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
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private AlmacenRepository almacenRepository;

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
        Producto producto;
        Categoria categoria;
        Almacen almacen;
        if(stock == null){
            return null;
        }else{

            if(stockDTO.getProductoDTO()==null){
                producto = stock.getProducto();
            }else{
                producto = productoRepository.findById(stockDTO.getProductoDTO().getId()).orElse(null);
            }
            if(stockDTO.getCategoriaDTO()==null){
                categoria = stock.getCategoria();
            }else{
                categoria = categoriaRepository.findById(stockDTO.getCategoriaDTO().getId()).orElse(null);
            }
            if(stockDTO.getAlmacenDTO()==null){
                almacen = stock.getAlmacen();
            }else{
                almacen = almacenRepository.findById(stockDTO.getAlmacenDTO().getId()).orElse(null);
            }

            stock.setProducto(producto);
            stock.setAlmacen(almacen);
            stock.setCantidad(stockDTO.getCantidad());
            stock.setCategoria(categoria);
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
    public List<StockDTO> buscarporCategoria(Integer id_categoria){
        return stockMapper.toDTO(stockrepository.buscarporCategoria(id_categoria));
    }

    public List<StockDTO> buscarporProductos(Integer id_producto){
        return stockMapper.toDTO(stockrepository.buscarporProductos(id_producto));
    }

}
