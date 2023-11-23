package com.example.agitana.converter;

import com.example.agitana.dto.*;
import com.example.agitana.models.*;
import com.example.agitana.service.AlmacenService;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.ProductoService;
import com.example.agitana.service.TipoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class StockMapper {
    @Autowired
    protected CategoriaService categoriaService;
    @Autowired
    protected AlmacenService almacenService;
    @Autowired
    protected ProductoService productoService;

    @Autowired
    protected TipoService tipoService;

    ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);
    CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);
    AlmacenMapper almacenMapper = Mappers.getMapper(AlmacenMapper.class);

    @Mapping(source = "producto", target = "productoDTO", qualifiedByName = "conversorProductoDTO")
    @Mapping(source = "almacen", target = "almacenDTO", qualifiedByName = "conversorAlmacenDTO")
    @Mapping(source = "categoria", target = "categoriaDTO", qualifiedByName = "conversorCategoriaDTO")
    public abstract StockDTO toDTO(Stock entity);
    @Mapping(source = "productoDTO", target = "producto", qualifiedByName = "conversorProductoEntity")
    @Mapping(source = "almacenDTO", target = "almacen", qualifiedByName = "conversorAlmacenEntity")
    @Mapping(source = "categoriaDTO", target = "categoria", qualifiedByName = "conversorCategoriaEntity")
    public abstract Stock toEntity(StockDTO dto);

    public abstract List<StockDTO> toDTO(List<Stock> listEntity);

    public abstract List<Stock> toEntity(List<StockDTO> listDTOs);

    @Named(value = "conversorAlmacenEntity")
    Almacen conversor(AlmacenDTO dto){
        return almacenService.getById(dto.getId());
    }

    @Named(value = "conversorAlmacenDTO")
    AlmacenDTO convertir(Almacen entity){
        return almacenMapper.toDTO(entity);
    }
    @Named(value = "conversorProductoEntity")
    Producto conversor(ProductoDTO dto){
        return productoService.getById(dto.getId());
    }

    @Named(value = "conversorProductoDTO")
    ProductoDTO convertir(Producto entity){
        return productoMapper.toDTO(entity);
    }

    @Named(value = "conversorCategoriaEntity")
    Categoria conversor(CategoriaDTO dto){
        return categoriaService.getById(dto.getId());
    }

    @Named(value = "conversorCategoriaDTO")
    CategoriaDTO convertir(Categoria entity){
        return categoriaMapper.toDTO(entity);
    }

}
