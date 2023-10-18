package com.example.agitana.converter;


import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Categoria;
import com.example.agitana.models.Producto;
import com.example.agitana.models.Tipo;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.TipoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductoMapper {

    @Autowired
    protected CategoriaService categoriaService;

    @Autowired
    protected TipoService tipoService;

    CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);
    TipoMapper tipoMapper = Mappers.getMapper(TipoMapper.class);

    @Mapping(source = "categoria", target = "categoriaDTO", qualifiedByName = "conversorCategoriaDTO")
    @Mapping(source = "tipo", target = "tipoDTO", qualifiedByName = "conversorTipoDTO")
    public abstract ProductoDTO toDTO(Producto entity);

    @Mapping(source = "categoriaDTO", target = "categoria", qualifiedByName = "conversorCategoriaEntity")
    @Mapping(source = "tipoDTO", target = "tipo", qualifiedByName = "conversorTipoEntity")
    public abstract Producto toEntity(ProductoDTO dto);

    public abstract List<ProductoDTO> toDTO(List<Producto> listEntity);

    public abstract List<Producto> toEntity(List<ProductoDTO> listDTOs);

    @Named(value = "conversorCategoriaEntity")
    Categoria conversor(CategoriaDTO dto){
        return categoriaService.getById(dto.getId());
    }

    @Named(value = "conversorCategoriaDTO")
    CategoriaDTO convertir(Categoria entity){
        return categoriaMapper.toDTO(entity);
    }
    @Named(value = "conversorTipoEntity")
    Tipo conversor(TipoDTO dto){
        return tipoService.getById(dto.getId());
    }

    @Named(value = "conversorTipoDTO")
    TipoDTO convertir(Tipo entity){
        return tipoMapper.toDTO(entity);
    }
}
