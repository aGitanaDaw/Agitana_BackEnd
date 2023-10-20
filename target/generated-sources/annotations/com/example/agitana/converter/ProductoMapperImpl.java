package com.example.agitana.converter;

import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.models.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-20T18:48:38+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ProductoMapperImpl extends ProductoMapper {

    @Override
    public ProductoDTO toDTO(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setCategoriaDTO( convertir( entity.getCategoria() ) );
        productoDTO.setTipoDTO( convertir( entity.getTipo() ) );
        productoDTO.setId( entity.getId() );
        productoDTO.setNombre( entity.getNombre() );

        return productoDTO;
    }

    @Override
    public Producto toEntity(ProductoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( conversor( dto.getCategoriaDTO() ) );
        producto.setTipo( conversor( dto.getTipoDTO() ) );
        producto.setId( dto.getId() );
        producto.setNombre( dto.getNombre() );

        return producto;
    }

    @Override
    public List<ProductoDTO> toDTO(List<Producto> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( listEntity.size() );
        for ( Producto producto : listEntity ) {
            list.add( toDTO( producto ) );
        }

        return list;
    }

    @Override
    public List<Producto> toEntity(List<ProductoDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Producto> list = new ArrayList<Producto>( listDTOs.size() );
        for ( ProductoDTO productoDTO : listDTOs ) {
            list.add( toEntity( productoDTO ) );
        }

        return list;
    }
}
