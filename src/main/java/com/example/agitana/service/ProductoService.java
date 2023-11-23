package com.example.agitana.service;

import com.example.agitana.Repository.CategoriaRepository;
import com.example.agitana.Repository.ProductoRepository;
import com.example.agitana.Repository.TipoRepository;
import com.example.agitana.converter.ProductoMapper;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.models.Categoria;
import com.example.agitana.models.Producto;
import com.example.agitana.models.Tipo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
public class  ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public Producto getById(Integer id){
        return productoRepository.findById(id).orElse(null);
    }
    public List<ProductoDTO> listarProductos() {
        return productoMapper.toDTO(productoRepository.findAll());
    }
    private ProductoDTO conversor(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        return productoDTO;
    }
    public ProductoDTO listarProductoPorId(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            return productoMapper.toDTO(producto);
        } else {
            return null;
        }
    }
    public ProductoDTO createProducto(ProductoDTO productoDTO){
        return productoMapper.toDTO(productoRepository.save(productoMapper.toEntity(productoDTO)));
    }

    public Producto modificarProducto(ProductoDTO productoDTO){
        Producto producto = productoRepository.findById(productoDTO.getId()).orElse(null);

        if(producto == null){
            return null;
        }else{
            producto.setNombre(productoDTO.getNombre());

            Categoria categoria = categoriaRepository.findById(productoDTO.getCategoriaDTO().getId()).orElse(null);
            Tipo tipo = tipoRepository.findById(productoDTO.getTipoDTO().getId()).orElse(null);

                producto.setCategoria(categoria);
                producto.setTipo(tipo);
                Producto productoModificado = productoRepository.save(producto);
                return productoModificado;

        }

    }

    public String eliminarProducto(Integer id) {
        Producto productoEliminar = productoRepository.findById(id).orElse(null);
        if (productoEliminar != null) {
            productoRepository.delete(productoEliminar);
            return "Datos eliminados correctamente";
        } else {
            return "No se ha podido eliminar el producto";
        }
    }
}
