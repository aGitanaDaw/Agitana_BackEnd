package com.example.agitana.service;

import com.example.agitana.Repository.ProductoRepository;
import com.example.agitana.models.productos;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<productos> listarProductos() {
        return productoRepository.findAll();
    }


}