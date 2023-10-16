package com.example.agitana.converter;

import com.example.agitana.service.ProductoService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductoMapper {

    @Autowired
    protected ProductoService productoService;

}
